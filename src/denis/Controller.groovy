package denis

import groovy.sql.Sql

sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

sql.execute("""
               DROP TABLE IF EXISTS `groups`;
                     CREATE TABLE `groups` (
  `groups_id` int(11) NOT NULL AUTO_INCREMENT,
  `groups_name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`groups_id`)
)

                    """
);

sql.execute("""
                      DROP TABLE IF EXISTS `user`;
                      CREATE TABLE `user` (
                      `userId` int(11) NOT NULL AUTO_INCREMENT,
                      `lastname` varchar(200) NOT NULL,
                      `midlename` varchar(150) NOT NULL,
                      `name` varchar(150) NOT NULL,
                      `login` varchar(45) NOT NULL,
                      `groups_id` int(7) DEFAULT NULL,
                      `status` int(1) DEFAULT NULL,
                      `birthday` date DEFAULT NULL,
                      PRIMARY KEY (`userId`),
                      UNIQUE KEY `login_UNIQUE` (`login`),
                      CONSTRAINT `FR_GROUP` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`groups_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
                    )
                    """
);
def groupInsert = """
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('1', 'Группа1');
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('2', 'Группа2');
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('3', 'Группа3');
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('4', 'Группа4');
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('5', 'Группа5');
INSERT INTO GROUPS (`groups_id`, `groups_name`) VALUES ('6', 'Группа6');
                    """
try {
    sql.execute(groupInsert);
    sql.commit()
    println("Successfully groups committed")
}catch(Exception ex) {
    sql.rollback()
    println("Transaction groups rollback")
}

def userInsert = """
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('1', 'serg', '1', '1', '1965-01-23', 'Букин', 'Сергеевич', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('2', 'oleg', '1', '1', '1970-02-18', 'Митин', 'Алексеевич', 'Олег');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('3', 'ole', '1', '1', '1970-02-19', 'Боржоми', 'Олегович', 'Александр');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('4', 'mux', '1', '1', '1980-03-19', 'Мухин', 'Иванович', 'Иван');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('5', 'bor', '2', '1', '1988-03-19', 'Борисов', 'Иванович', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('6', 'sor', '2', '1', '1988-03-21', 'Бунин', 'Иванович', 'Михаил');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('7', 'dog', '3', '1', '1988-07-22', 'Кутилин', 'Михайлович', 'Игорь');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('8', 'dogs', '4', '0', '2000-07-22', 'Кутилин', 'Михайлович', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('9', 'bun', '4', '1', '2000-07-25', 'Бунин', 'Михайлович', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('10', 'sugr', '4', '1', '2000-07-28', 'Митин', 'Иванович', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('11', 'gr', '5', '1', '2000-08-28', 'Букин', 'Иванович', 'Михаил');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('12', 'grp', '6', '1', '2000-09-05', 'Боржоми', 'Иванович', 'Михаил');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('13', 'foo', '1', '1', '2000-06-28', 'Михайлов', 'Дмитриевич', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('14', 'froo', '2', '0', '2000-06-30', 'Оралов', 'Алексеевич', 'Дмитрий');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('15', 'guk', '2', '1', '2000-06-01', 'Оралов', 'Михайлович', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('16', 'frew', '2', '1', '2000-05-01', 'Букин', 'Дмитриевич', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('17', 'sss', '2', '1', '2000-07-01', 'Лермонтов', 'Александрович', 'Дмитрий');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('18', 'sert', '2', '1', '2000-08-01', 'Лермонтов', 'Алексеевич', 'Сергей');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('19', 'push', '2', '1', '1864-07-01', 'Пушкин', 'Сергеевич', 'Александр');
        INSERT INTO USER (`userId`, `login`, `groups_id`, `status`, `birthday`, `lastname`, `midlename`, `name`) VALUES ('20', 'georg', '2', '1', '1984-08-01', 'Дубравин', 'Алексеевич', 'Георгий');
"""
try {
    sql.execute(userInsert);
    sql.commit()
    println("Successfully user committed")
}catch(Exception ex) {
    sql.rollback()
    println("Transaction user rollback")
}
///////////////////////////////
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
List<Integer> listGroup = new ArrayList<>();
println("2.Введите id одной из групп для поиска: ")
sql.eachRow("select * from groups g "){result ->
    Integer res = result.groups_id
    listGroup.add(res)
    println("id= " + result.groups_id + " группа=" + result.groups_name)
}
def group_id = reader.readLine();
sql.eachRow("select * from user u, groups g where u.groups_id=g.groups_id and u.groups_id=? order by userId", [group_id]) {result ->
    def stat = (result.status==1)?"актвивен":"нет"
    println(result.userId + "." + result.lastname + " " + result.name + " "
            + result.midlename + " " + result.birthday + " " + result.login + " " + result.groups_name + " " + stat)
}


println()
println("2.Введите статус человека для поиска(1-активен, 0 - нет): ")
def status = reader.readLine();
sql.eachRow("select * from user u, groups g where u.groups_id=g.groups_id and u.status=? order by userId", [status]) {result ->
    def stat = (result.status==1)?"актвивен":"нет"
    println(result.userId + "." + result.lastname + " " + result.name + " "
            + result.midlename + " " + result.birthday + " " + result.login + " " + result.groups_name + " " + stat)
}


println()
println("3.Список групп, где больше двух пользователей:  ")
sql.eachRow("select g.groups_name, count(userId) as count_us from user u, groups g where u.groups_id=g.groups_id GROUP  by g.groups_name having count_us > 2") {
    println("${it.groups_name} ${it.count_us} ")
}

println()
println("4.Список людей с Днем Рождения в прошлом и позапрошлом месяце:  ")
Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+2:00"));
sql.eachRow("select * from user u, groups g where u.groups_id=g.groups_id order by u.userId") {resultSet ->
    while(resultSet.next()){
        String res = resultSet.birthday
        Integer r = Integer.parseInt(res.substring(5,7))
        def stat = (resultSet.status==1)?"актвивен":"нет"
        (((cal.get(Calendar.MONTH)-2) < r)&(r < (cal.get(Calendar.MONTH)+1)))?println(resultSet.userId + "."
                + resultSet.lastname + " " + resultSet.name+ " "+resultSet.midlename+ " "+resultSet.birthday+ " "
                +resultSet.login+ " "+resultSet.groups_name+ " "+ stat):null
    }
}


println()
println("5.Для изменения статуса сотрудника или перевода в другую группу введите идентификатор сотрудника:  ")
def userIdUpdate = reader.readLine();
println("Введите на какой статус необходимо поменять(1-активен, 0 - нет):  ")
def statusUpdate = Integer.parseInt(reader.readLine());
if((statusUpdate == 0)||(statusUpdate == 1)) {
    sql.executeUpdate("update user u set u.status = ? where u.userId = ?", [statusUpdate, userIdUpdate])
}
else println("На такой статус поменять нельзя!")

println("Введите идентификатор группы в которую необходимо перевести сотурдника:  ")
def groupIdUpdate = Integer.parseInt(reader.readLine())
if(listGroup.contains(groupIdUpdate)){
    sql.executeUpdate("update user u set u.groups_id = ? where u.userId = ?", [groupIdUpdate, userIdUpdate])
}
else println("Такой группы нет")


println()
println("6.Для удаления сотрудника введите идентификатор:  ")
def userId = reader.readLine();
sql.execute("delete from user where userId = ?" , [userId])

println()
println("7.Список всех сотрудников:  ")
sql.eachRow("select * from user u, groups g where u.groups_id=g.groups_id order by userId") { result ->
    def stat = (result.status==1)?"актвивен":"нет"
    println(result.userId + "." + result.lastname + " " + result.name + " "
            + result.midlename + " " + result.birthday + " " + result.login + " " + result.groups_name + " " + stat)
}

sql.close()


