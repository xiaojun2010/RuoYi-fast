package com.ruoyi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 --add-opens java.base/java.lang=ALL-UNNAMED
 --add-opens java.base/java.lang.reflect=ALL-UNNAMED
 --add-opens java.base/java.util=ALL-UNNAMED
 --add-opens java.base/java.util.concurrent=ALL-UNNAMED
 --add-opens java.base/java.io=ALL-UNNAMED
 --add-opens java.base/java.text=ALL-UNNAMED
 --add-opens java.base/java.math=ALL-UNNAMED
 --add-opens java.base/java.net=ALL-UNNAMED
 --add-opens java.base/java.time=ALL-UNNAMED
 --add-opens java.base/sun.nio.ch=ALL-UNNAMED
 --add-opens java.base/sun.net.www.protocol.http=ALL-UNNAMED
 --add-opens java.rmi/sun.rmi.transport=ALL-UNNAMED
 --add-opens java.desktop/java.awt.font=ALL-UNNAMED

 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ruoyi.project.*.*.mapper")
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}