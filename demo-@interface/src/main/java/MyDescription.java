import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.METHOD}) // 描述方法 Method declaration
@Retention(RetentionPolicy.RUNTIME) // 定义该注解的生命周期
@Documented // 注解是否将包含在JavaDoc中
public @interface MyDescription {

    String entity() default "";// 目标

    String[] params() default {};// 参数

}
