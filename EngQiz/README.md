# Problem Meet
#### Case sensitive in intellij and git

##### Problem
Package not use lower case, and try to use intellij refactor to change to capital. However, if we change pacakge from lower case to capital, the package will not be update (still upper case).

##### Why
Git and intellij do package refactor is not case sensitive. 

##### How to resolve
Rename to other name and push to git, then rename to correct name and push to git.

##### Another way to solve
Modify git configuration `git config core.ignorecase false`.

---
#### JPA repository Interface enable

##### Problem 
When spring initialized, the console shows `Field questionDAO in rifu.demo.engqiz.service.service.QuestionService required a bean of type 'rifu.demo.engqiz.core.dao.QuestionDAO' that could not be found.`

##### why
DAOs(Repositories) are interface. Therefore, they cannot be scanned by spring

##### How to resolve
Add spring config for setting these repository enable.
```
@EnableJpaRepositories(
    basePackages = {
        "rifu.demo.engqiz.core.dao"
    }
)
 ```
