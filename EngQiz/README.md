# Problem Meet
## Case sensitive in intellij and git
##### Problem
Package not use lower case, and try to use intellij refactor to change to capital. However, if we change pacakge from lower case to capital, the package will not be update (still upper case).

##### Why
Git and intellij do package refactor is not case sensitive. 

##### How to resolve
Rename to other name and push to git, then rename to correct name and push to git.

##### Another way to solve
Modify git configuration `git config core.ignorecase false`.
