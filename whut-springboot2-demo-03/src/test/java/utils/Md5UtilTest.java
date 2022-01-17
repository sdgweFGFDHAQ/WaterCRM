package utils;

import cn.hutool.core.date.ChineseDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @Author 1
 * @Date 2021/7/22
 * @Description IntelliJ IDEA
 **/
@Slf4j
public class Md5UtilTest {

    @Test
    public void md5UtilTest() {
        String string = "admin";
        String s = DigestUtils.md5DigestAsHex(string.getBytes(StandardCharsets.UTF_8));
        String s1 = "字符串拼接";
        log.info("s值:{},s1值:{}", s, s1);
        ChineseDate cd = new ChineseDate(2000, 1, 1);
        System.out.println(cd.getChineseZodiac());
        System.out.println(cd.getCyclicalYMD());
    }
}
