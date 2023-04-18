# Event Calender 
Календарь событий - это простое приложение для хранения событий Android с облачным резервным копированием.

## Используемая технология::<b>
* Java 
* MVVM Achitectural Pattern
* Room 
* JUnit4 (unit testing)
* LiveData
* Firebase Authenthication
* Cloud Firestore</b>
<br/>

<b>Случаи использования::</b> 
1. Пользователь открывает приложение
2. Рагистрируется/Входит в свой аккаунт
3. Смотрит еженедельный календарь с текущими датами событий
4. Пользователь может добавлять новые события
5. Пользователь может сделать резервное копирование в облако
6. Пользователь может сгрузить данные с облака к себе на устройство

### UI Дизайн в Figma
------------------

<p align="center"> <img src="https://user-images.githubusercontent.com/30120066/135445079-a3ad392e-5276-4cc4-9d18-5741c3a41313.jpg" width="50%"/></p>

<br><br>

## How I approached
<b>1.</b> First did the requirement analysis and use case diagram<br>
<b>2.</b> Google searched for UI design and got inpired from them<br>
<b>3.</b> Designed my UI<br>
<b>4.</b> Prepared android project for <b>MVVM pattern</b> (made all packages and all and spd , room, view-model etc dependencies) <br>
<b>5.</b> Coded xml of homepage and Event input dialog<br>
<b>6.</b> Test CalenderUtils functionality using <b>JUnit4</b><br>
<b>7.</b> Thought about <b>Class diagram</b> but here only simple one class so didn't design any<br>
<b>8.</b> Event info data store to <b>ROOM database</b> and test if it's working<br>
<b>8.</b> Add firebase dependencies and project add to firebase<br>
<b>9.</b> XML of Login Register pages and Code functionality<br>
<b>10.</b> Backup and restore from cloud firestore<br>
<br>


##Используемые структуры данных

* **HashMap**
* **Array**
* **ArrayList**


## Принципы ООП
* <b> Single Responsibility:</b> «Event» и «CalendarUtils» несут единую ответственность. Например: CalendarUtils имеет дело только с форматированием данных, связанных с календарем.

## Скриншоты приложения


<p align="center">
  <img alt="screen1" src="https://user-images.githubusercontent.com/30120066/135463398-7284c294-9ca7-451f-904e-fc5e9df57872.png" width="30%">
&nbsp; &nbsp; &nbsp; &nbsp;
  <img alt="screen2" src="https://user-images.githubusercontent.com/30120066/135463443-147ab93e-db9b-4c88-bd3e-d33424664c08.png" width="30%">

  <img alt="screen3" src="https://user-images.githubusercontent.com/30120066/135463453-17af8be1-8416-4b87-86f1-6b5666ffe005.png" width="30%">
</p>


