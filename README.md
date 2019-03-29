# spring_hibernate_user_management
This is tutorial project of spring mvc and hibernate.

## Spring MVC Key Knowledge:
### Core Controller(DispatcherServlet):
```java
  It is resonsible for receiving http requests and load configuration files to initialize ApplicationContext.
  Can be configured in web.xml.
```

### SimpleUrlHandlerMapping:
```
  Used to map request url to actual controller bean
```

### Some logic controller:
```
  1. AbstractController: nothing special
  2. ParameerizableViewController: directly return a view without doing anything
  3. UrlFilenameViewController: do some prefix and suffix to 
     the request name and then return view
  4. SimpleFormController: has onSubmit(Object command) function, 
     command object contains form parameters. Remember need to 
     configure commandClass in applicationContext.xml
  5. MultiActionController: use request parameter "method" to map to different member functions.
     Need to configure methodNameResolver in applicationContext.xml
  ```
  
### ResourceViewResolver:
```
  Do some prefix and suffix to the view name so that it can map to the actual location of the view resource
  ```

### Transaction Management
  #### Programming style transaction management: Need to implement TransactionCallback interface
   ```Java
  <bean class="org.springframework.transaction.support.TransactionTemplate" id="transactionTemplate">
  - <property name="transactionManager">
      <ref bean="transactionManager"/>
    </property>
    <property name="propagationBehaviorName">
      <value>PROPAGATION_REQUIRED</value>
    </property>
  </bean>
  
  <!-- Declare transaction manager -->
  <bean class="org.springframework.jdbc.datasource.DataSourceTransactionManager" id="transactionManager">
    <property name="dataSource">
      <ref bean="dataSource"/>
  </property>
  </bean>

<!-- Inject transactionManager, transactionTemplate, dataSource for class TransactionExample-->
  <bean class="com.mr.transaction.TransactionExample" id="transactionExample">
    <property name="dataSource">
      <ref bean="dataSource"/>
  </property>
  <property name="transactionManager">
    <ref bean="transactionManager"/>
  </property>
  <property name="transactionTemplate">
    <ref bean="transactionTemplate"/>
  </property>
</bean>
...
 public void transactionOperation() {
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus status) {
                Connection conn = DataSourceUtils.getConnection(dataSource);//Get database connection
                try {
                    Statement stmt = conn.createStatement();
                    //ִExecute two queries
                    stmt.execute("insert into tb_user(name,age,sex) values('Tony','26','Male')");
                    int a=0;// Make it fail on purpoes
                    a=9/a;
                    stmt.execute("insert into tb_user(name,age,sex) values('Jeny','22','Female')");
                    System.out.println("Successfully insert two entries.");
                } catch (Exception e) {
                    transactionManager.rollback(status);//Transaction rollback
                    System.out.println("Query failed, transaction rollbacks.");
                    System.out.println("Reason"+e.getMessage());
                }
                return null;
            }
        });
    }
 ```
 
   #### Declaration style transaction manager: Uses spring AOP, need to create proxy object
   ```Java
   <!-- 定义TransactionProxy -->
  <bean class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean" id="transactionProxy">
    <property name="transactionManager">
      <ref local="transactionManager"/>
    </property>
    <property name="target">
       <bean class="com.mr.dao.AddDAO" id="addDAO">
        <property name="dataSource">
          <ref local="dataSource"/>
         </property>
      </bean>
  </property>
  <property name="proxyTargetClass" value="true"/>
  <property name="transactionAttributes">
    <props>
      <prop key="add*">PROPAGATION_REQUIRED</prop> //Map function name begins with "add"
    </props>
  </property>
</bean>
...
 public static void main(String[] args) {
    	ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");  //Load config file
        AddDAO addDAO = (AddDAO)factory.getBean("transactionProxy");//Get proxy object
        User user = new User();
        user.setName("Tony");
        user.setAge(30);
        user.setSex("Male");
        addDAO.addUser(user);//ִDo da operation
    }
  ```
  ## Hibernate Key Points
  ```
  1. Hibernate Configuration File
  2. ORM class
  3. ORM class mapping file (e.g. *hbm.xml)
  4. First and second level cache
  5. Lazy (e.g. session.load(...))
  ```

      
