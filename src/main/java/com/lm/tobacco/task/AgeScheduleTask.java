package com.lm.tobacco.task;

import com.lm.tobacco.generated.entity.Employee;
import com.lm.tobacco.generated.mapper.EmployeeMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author liming356
 * @since 2018/9/27/027
 */
@EnableScheduling
@Component
public class AgeScheduleTask {

  private Logger logger = LogManager.getLogger(AgeScheduleTask.class);

  @Autowired private EmployeeMapper employeeMapper;

  public void task() throws Exception {
    logger.info("更新年龄：" + getAge("1991-06-20"));
    List<Employee> employees = employeeMapper.selectByExample().build().execute();
    // SelectStatementProvider selectStatement = select()
    for (Employee employee : employees) {
      employee.setAge(getAge(employee.getBirthday()));
      employeeMapper.updateByPrimaryKey(employee);
    }
  }

  /**
   * 由出生日期获得年龄,String日期
   *
   * @param strDate
   * @return
   * @throws ParseException
   */
  public int getAge(String strDate) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return getAge(sdf.parse(strDate));
  }

  /**
   * 由出生日期获得年龄，Date日期
   *
   * @param birthDay
   * @return
   * @throws Exception
   */
  public int getAge(Date birthDay) {
    Calendar cal = Calendar.getInstance();
    if (cal.before(birthDay)) {
      throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
    }
    int yearNow = cal.get(Calendar.YEAR);
    int monthNow = cal.get(Calendar.MONTH);
    int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
    cal.setTime(birthDay);
    int yearBirth = cal.get(Calendar.YEAR);
    int monthBirth = cal.get(Calendar.MONTH);
    int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
    int age = yearNow - yearBirth;
    if (monthNow <= monthBirth) {
      if (monthNow == monthBirth) {
        if (dayOfMonthNow < dayOfMonthBirth) {
          age--;
        }
      } else {
        age--;
      }
    }
    return age;
  }
}
