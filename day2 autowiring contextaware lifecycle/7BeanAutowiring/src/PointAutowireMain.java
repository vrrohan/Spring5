import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 	<bean id="rad2" class="Radius">
		<property name="radii" value="8"></property>
	</bean>
Exception Error - 
	Unsatisfied dependency expressed through bean property 'rA'; nested exception is org.springframework.beans.factory.NoUniqueBeanDefinitionException: 
	No qualifying bean of type 'Radius' available: expected single matching bean but found 2: rad,rad2
	
In case of byType autowiring mode, bean id and reference name may be different. But there must be only one bean of a type. It internally uses setter injection.

	<bean id="b1" class="org.sssit.B"></bean>  
	<bean id="a" class="org.sssit.A" autowire="byType"></bean>  

In this case, it works fine because you have created an instance of B type. It doesn't matter that you have different bean name than reference name.
But, if you have multiple bean of one type, it will not work and throw exception. Let's see the code where are many bean of type B.

	<bean id="b1" class="org.sssit.B"></bean>  
	<bean id="b2" class="org.sssit.B"></bean>  
	<bean id="a" class="org.sssit.A" autowire="byName"></bean>  
In such case, it will throw exception.
*/

public class PointAutowireMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		Triangle triOne = (Triangle) appContext.getBean("tri");
		System.out.println(triOne);
		
		Line lineA = (Line) appContext.getBean("lin");
		System.out.println(lineA);
		
		Circle cirOne = (Circle) appContext.getBean("cir");
		System.out.println(cirOne);
		
	}

}

/*
public class Book
{
            private Author author;
            public Book(Author author) {
                        this. customer = customer;
            }
            public void setAuthor (Author author) {
                        this.author = author;
            }
            //.......
}

public class Author
{
            //......
}

1. Auto-Wiring ‘byName’

In the Spring framework, everything is given a name. Bean properties are given a name and the beans that are wired to those properties, too.
The name of a property happens to match the names of the bean that is to be wired to that property. Spring framework that the bean should be automatically wired into the property.

Autowired a bean by property name. In this case, since the name of the "author" bean is the same name of the “book” bean’s property (“Author”), 
Spring will be autowired to it via the setter method – “setAuthor (Author author)”.

<bean id="book" class="com.spring.common.Book" autowire="byName" />  
<bean id="author" class="com.spring.common.Author" />

2. Auto-Wiring ‘byType’

Autowiring using byType works similarly to byName. When attempting to autowire a property byType, Spring will look T beans whose type is assigned to the property’s type.
Autowire a bean by data type. In this case, the data type of the “author” bean is the same as the data type of the “book” bean’s property (Author object), so, Spring will autowire it via the setter method – “setAuthor (Author author)“.

<bean id="book" class="com.spring.common.Book" autowire="byType" />
<bean id="author" class="com.spring.common.Author" />

3. Auto-Wiring ‘constructor’

If your bean is configured using a constructor injection, you may choose to put the <constructor-arg> elements.constructor arguments from beans in the Spring context.
Autowire a bean by property data type in constructor arguments. Since the data type of “author” bean is same as the constructor argument data type in “book” bean’s property (Author object)
Spring autowired it using the constructor method – “public Book(Author author)“.

<bean id="vehicle" class="com.spring.common.Vehicle" autowire="constructor" />
<bean id="author" class="com.spring.common.Author" />

4. Auto-Wiring ‘autodetect’

If you want to autowire beans, but you can’t decide which type of autowiring to use, have no fear. We can set the autowire attribute to autodetect.
If a default constructor is found, it first tries to autowire by “constructor”; otherwise, if it doesn't work but fails, then it tries to autowire using “byType”. 
In this case, since there is a default constructor in the “Book” class, Spring autowired it via the constructor method – “public Book (Author author) “.

<bean id="vehicle" class="com.spring.common.Vehicle" autowire="autodetect" />
<bean id="author" class="com.spring.common.Author" />
*/
