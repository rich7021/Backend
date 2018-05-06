## Problems met
### Problem

Using 2 SqlSessionFactory to configure for Multi-datasource will show error: 

```
Parameter 0 of method sqlSessionTemplate in org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration required a single bean, but 2 were found:
```

#### Solutions

Using SqlSessionTemplate to configure.

#### Reason

Wait for clarify.

---

### Problem

Set the mappere with Java based config for 2 datasource respectively, the error will show
```
file [C:\Users\User\Documents\workspace\Backend\mybatis-spring\target\classes\rifu\demo\mybatisspring\mapper\ds2\AuthenticationMapper.class] required a single bean, but 2 were found:
```

#### Solutions

Usnig annotaion @MapperScan to all mapper configuraions will work fine.

#### Reason

Wait for clarify
