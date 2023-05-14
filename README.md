
# CRM PROJECT - EMPLOYEES/STUDENTS MANAGEMENT


## Main function

* Login ,register 
* Able to see all roles of members , all projects , tasks , dashboard
* Able to see the proces of all projects , tasks
* Basic function such as update , add , delete , search



## Techonolgy

**Database**
- Table jobs :
    * id (primary key)
    * name : job name
    * start_date : start date of job
    * end_date : end date of job

- Table roles : 
    * id (primary key)
    * name : role name 
    * description : role description

- Table status :
    * id (primary key)
    * name : status name

- Table tasks :
    * id (primary key)
    * name : task name
    * start_date : start date of task
    * end_date : end date of task
    * user_id (foreign_key references users) : id of user 
    * job_id (foreign_key references jobs) : id of job
    * status_id (foreign_key references status) : id of status


- Table users :
    * id (primary key)
    * email : user email
    * password : user password
    * fullname : user fullname
    * avatar : user avatar
    * role_id (foreign_key references roles) : id of role


**Backend**
* IntelliJ IDEA
* Java version 11
* Servlet version 4.0.1
* Apache tomcat 9
* Maven
* Use Mysql to store and query data
* Gson version 2.10 : to transfer object to json 
* Use docker to deploy


    
## API Reference

*  **Jobs API**
    #### Get all jobs

    ```http
    GET /api/jobs
    ```

    #### Add job

    ```http
    POST /api/jobs/add
    ```

<<<<<<< HEAD
   | Parameter | Type     | Description                       |
   | :-------- | :------- | :-------------------------------- |
   | `name`      | `string` | name of job  |
   | `start`      | `string` |start date of job |
   | `end`      | `string` | end date of job |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `name`      | `string` | name of job  |
    | `start`      | `string` |start date of job |
    | `end`      | `string` | end date of job |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349

    #### Update job

    ```http
    POST /api/jobs/update
    ```

<<<<<<< HEAD
   | Parameter | Type     | Description                       |
   | :-------- | :------- | :-------------------------------- |
   | `name`      | `string` | name of job  |
   | `start`      | `string` |start date of job |
   | `end`      | `string` | end date of job |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `name`      | `string` | name of job  |
    | `start`      | `string` |start date of job |
    | `end`      | `string` | end date of job |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349

    #### Delete job

    ```http
    POST /api/jobs/delete
    ```

<<<<<<< HEAD
   | Parameter | Type     | Description                       |
   | :-------- | :------- | :-------------------------------- |
   | `id`      | `int` | id of job  |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `id`      | `int` | id of job  |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349

*  **Roles API**
    #### Get all roles

    ```http
    GET /api/roles
    ```

    #### Add role

    ```http
    GET /api/roles/add
    ```

<<<<<<< HEAD
   | Parameter | Type     | Description                       |
   | :-------- | :------- | :-------------------------------- |
   | `name`      | `string` | name of role  |
   | `description`      | `string` |description of role |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `name`      | `string` | name of role  |
    | `description`      | `string` |description of role |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349


    #### Update role

    ```http
    GET /api/roles/update
    ```

    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `name`      | `string` | name of role  |
    | `description`      | `string` |description of role |


    #### Delete roles

    ```http
    GET /api/roles/delete
    ```

    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `id`      | `int` | id of role  |

*  **Tasks API**

    #### Add task

    ```http
    POST /api/tasksStatusJobsUsers/add
    ```

<<<<<<< HEAD
   | Parameter | Type        | Description        |
   |:------------|:-------------------| :-------------------------------- |
   | `taskName`      | `string`    | name of task       |
   | `start`      | `string`    | start date of task |
   | `end`      | `string`    | start date of task |
   | `user_id`      | `int`       | user id of task    |
   | `status_id`      | `int`       | status id of task  |
   | `job_id`      | `int`       | job id of task     |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `taskName`      | `string` | name of task  |
    | `start`      | `string` |start date of task |
    | `end`      | `string` |start date of task |
    | `user_id`      | `int` |user id of task |
    | `status_id`      | `int` |status id of task |
    | `job_id`      | `int` |job id of task |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349


    #### Update task

    ```http
    POST /api/tasksStatusJobsUsers/update
    ```

    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `taskName`      | `string` | name of task  |
    | `start`      | `string` |start date of task |
    | `end`      | `string` |start date of task |
    | `user_id`      | `int` |user id of task |
    | `status_id`      | `int` |status id of task |
    | `job_id`      | `int` |job id of task |


    #### Delete task

    ```http
    POST /api/tasksStatusJobsUsers/delete
    ```

    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `id`      | `int` | id of task  |
    
*  **Users API**

    #### Get all users

    ```http
    GET /api/usersRoles
    ```
    #### Add user

    ```http
    POST /api/usersRolesAdd
    ```

<<<<<<< HEAD
   | Parameter | Type     | Description                       |
   | :-------- | :------- | :-------------------------------- |
   | `fullname`      | `string` | fullname of user  |
   | `email`      | `string` |email of user |
   | `password`      | `string` |password of user |
=======
    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `fullname`      | `string` | fullname of user  |
    | `email`      | `string` |email of user |
    | `password`      | `string` |password of user |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349



    #### Update user

    ```http
    POST /api/usersRoles/update
    ```

    | Parameter | Type     | Description                       |
<<<<<<< HEAD
| :-------- | :------- | :-------------------------------- |
=======
    | :-------- | :------- | :-------------------------------- |
>>>>>>> ce3db6e18a0fbd3607f009b6169bf512fe9f8349
    | `fullname`      | `string` | fullname of user  |
    | `email`      | `string` |email of user |
    | `password`      | `string` |password of user |


    #### Delete user

    ```http
    POST /api/usersRoles/delete
    ```

    | Parameter | Type     | Description                       |
    | :-------- | :------- | :-------------------------------- |
    | `id`      | `int` | id of user  |



## Installation

* Tool used in project
  * Docker
  * Mysql workbench
  * IntelliJ IDEA
    



* Download apache tomcat

```bash
  https://tomcat.apache.org/download-90.cgi (Core -> tar.gz)
```

* Download servlet library

```bash
  https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
```


* Download gson library

```bash
  https://mvnrepository.com/artifact/com.google.code.gson/gson
```

* Download mysql connector library

```bash
  https://mvnrepository.com/artifact/mysql/mysql-connector-java
```
    
## Demo

![login](https://github.com/LeeThanh24/CRM_project/assets/94585743/606a3610-723a-4dc2-8d68-9731fb9a57e3)
![dashboard](https://github.com/LeeThanh24/CRM_project/assets/94585743/cbb0bd09-c6b1-4c31-a479-0a0f9d9e8581)
![member](https://github.com/LeeThanh24/CRM_project/assets/94585743/336f6af5-3ebb-48bb-8925-e92ab02a4b04)
![role](https://github.com/LeeThanh24/CRM_project/assets/94585743/3b49e94b-b53c-4aab-882f-b99d512198c4)
![projectPage](https://github.com/LeeThanh24/CRM_project/assets/94585743/cc255a09-42b8-4995-9165-43be17371b51)
![task](https://github.com/LeeThanh24/CRM_project/assets/94585743/4b2cdbe7-baa3-408e-953d-a920fe3d1f01)


