# spring_hibernate_user_management
This is tutorial project of spring mvc and hibernate.

## Spring MVC Key Knowledge:
### Core Controller(DispatcherServlet):
It is resonsible for receiving http requests and load configuration files to initialize ApplicationContext. Can be configured in web.xml.

### SimpleUrlHandlerMapping:
Used to map request url to actual controller bean

### Some logic controller:
#### AbstractController: nothing special
#### ParameerizableViewController: directly return a view without doing anything
#### UrlFilenameViewController: do some prefix and suffix to the request name and then return view
#### SimpleFormController: has onSubmit(Object command) function, command object contains form parameters. Remember need to configure commandClass in applicationContext.xml
#### MultiActionController: use request parameter "method" to map to different member functions. Need to configure methodNameResolver in applicationContext.xml
#### ResourceViewResolver: do some prefix and suffix to the view name so that it can map to the actual location of the view resource

###
