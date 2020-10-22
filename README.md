# shiroadmin
一个练手的SpringBoot+Shiro的权限管理脚手架，帮助小白理解。

用户具有多个角色，某个角色可以有多个权限，可按需添加。

IDEA导入项目，导入数据库，修改数据库配置信息，启动。

/login 登录 http://localhost:8080/login?username=test&password=123456
/logout 退出
/unauth 无权限
/public  开放
/userList 只需登录可看
/systemadmin 系统管理员的角色可看
/menusystem  功能模块管理员的角色可看
/usersystem  用户管理员的角色可看
