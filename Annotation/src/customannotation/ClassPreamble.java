package customannotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@Documented
public @interface ClassPreamble {
    String author() default "Nguyen Quang Phu";
    String date();
    int currentRevision() default 1;
    String lastModify() default "N/A";
    String lastModifyBy() default "N/A";
    String[] reviwer();
}
