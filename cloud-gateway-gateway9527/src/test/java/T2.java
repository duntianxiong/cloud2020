import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author EiletXie
 * @Since 2020/3/12 15:43
 */
@Slf4j
public class T2 {

    public static void main(String[] args) {
//        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
//        System.out.println(zbj);
        //2020-03-12T15:44:15.064+08:00[Asia/Shanghai]

        //找到输入的字符串中出现次数最多的字符
        String str = "acfdsavfad";
        String info = T2.findNumber(str);
        log.info("result:{}", info);
    }

    /**
     * 功能描述: <br>
     * 〈 输入一个字符串，找到其中出现次数最多的字符 〉
     * @author : duntianxiong
     * @date : 2020/7/8 7:56 下午
     * @param str: 输入的字符串
     * @return : java.lang.String
     */
    private static String findNumber(String str) {
        Map<Character, Integer> map = new HashMap<>(16);
        for (int i = 0; i < str.length(); i++) {
            //map中有数据，则说明了;map中首次无数据，现将数字清零，避免原子类重复计数
            if (map.get(str.charAt(i))!=null){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i),1);
            }
        }

        //找到value最大的值；
        AtomicInteger num = new AtomicInteger(0);
        map.forEach((k, v) -> {
            if (v > num.get()){
                num.set(v);
            }
        });

        //通过最大值value找到相对应的key；
        AtomicReference atomicReference = new AtomicReference();
        map.forEach((k, v) -> {
            if (v == num.get()){
                atomicReference.set(k);
            }
        });

        return atomicReference.get().toString();
    }
}
