package com.lm.tobacco;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

/**
 * @author liming356
 * @since 2018/9/28/028
 */
public class FaceTest {

    //设置APPID/AK/SK
    public static final String APP_ID = "14304618";
    public static final String API_KEY = "qIKxdGDfNW20wkFu35onX2Nj";
    public static final String SECRET_KEY = "aT6fKeywes5LiIjdBeUXphp02gyBBDsL";

    public static void main(String[] args) throws Exception{
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("face_field", "age,beauty,expression,faceshape,gender,glasses,race,quality,facetype");
        options.put("max_face_num", "10");
        options.put("face_type", "LIVE");


        String image = new sun.misc.BASE64Encoder().encode(getByteArray());

        JSONObject res = client.detect(image, "BASE64", options);
        System.out.println(res.toString(2));
    }

    private static byte[] getByteArray() throws Exception {
        File file = new File("C:\\Users\\liming39\\Desktop\\u=1641210012,1992790924&fm=26&gp=0.jpg");
        FileInputStream fis = new FileInputStream(file);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while((len = fis.read(b)) != -1) {
            bos.write(b, 0, len);
        }

        byte[] fileByte = bos.toByteArray();
        return fileByte;
    }
}
