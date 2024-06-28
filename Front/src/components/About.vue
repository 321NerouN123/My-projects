<template>
    <Navigation />
    <div class="content">
        <div class="a"><img class="image" src="../assets/about-img2.jpg"></div>
        <div class="b">
            <b>Pixel Island</b>
            <p>Добро пожаловать на наш форум для инди-разработчиков! Здесь вы найдете обширную площадку для общения и обмена опытом
                 с другими единомышленниками. Мы рады предоставить возможность обсуждать широкий спектр тем: 
                 от игр и разработки до дизайна и новостей индустрии. Наше сообщество включает в себя как профессионалов, 
                 так и любителей, которые разделяют общую страсть к игровой индустрии. 
                 Присоединяйтесь к нам, чтобы обсудить интересующие вас вопросы и насладиться общением с единомышленниками!</p>
                 <button onclick="document.location='#/home'" class="back"><a href="#/Home">На главную</a></button>
            <br><br><br><br><br>
            <h3>Связь с нами:</h3>
            <ol>
                <li>slava.vlad01@mail.ru - По вопросам сотрудничества</li>
                <li>8-927-702-78-54 - Тех помощь</li>
            </ol>
                <h3>Наши социальные сети:</h3>
            <ol>
                <li>
                    <div class="list-block">
                        <a href="https://vk.com/"><img src="../assets/icons8-vk-com-48.png" width="50px" height="50px"></a>
                        <a href="https://ok.ru/"><img src="../assets/icons8-одноклассники-48.png" width="48px" height="48px"></a>
                        <a href="https://t.me/+bCjbmzzyFWsxYTUy"><img src="../assets/icons8-логотип-telegram-48.png" width="40px" height="40px"></a>
                    </div>
                    
                </li>
                
                
            </ol>
        </div>
    </div>
    <Footer />
</template>

<script>

</script>

<style scoped>
.content {
    width: 98%;
    min-height: 71vh;
    background: #27272c;
    margin: auto;
    padding-top: 20px;
    padding-bottom: 19px;
    display: flex;
    justify-content: space-around;
    padding-top: 70px;
}

.a {
    width: 45%;
    height: 65vh;
    border: 3px outset rgb(202, 64, 0);

}

.b {
    width: 50%;
    height: 65vh;
    background: #27272c;
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 18px;
    padding-top: 20px;
    display: block;
}

button {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    font-size: 15px;
    margin: auto;
    border-width: 5px;
    border-style: outset;
    border-color: rgb(189, 102, 21);
    border-radius: 9px;
    width: 140px;
    height: 40px;
    background: rgb(111,111,111);
    background: linear-gradient(180deg, rgba(111,111,111,1) 0%, rgba(47,47,47,1) 78%, rgba(33,31,31,1) 100%);
    box-shadow: inset 0px 0px 20px 0px #2c1400;
    transition: all 200ms ease; 
    
}

button:hover {
	box-shadow: inset 0px 0px 20px 0px #682f00;
    cursor: pointer;
}
button:active {
	position:relative;
	top:5px;  
}


.image {
    width: 100%;
    height: 100%;
}

b{
    margin-left: 20px;
    font-size: 20px;
    
}

p{
    line-height: 1.7;
    text-indent: 3em;
}

a:link{
    font-family: "Bitter", bold;
    color: rgb(242, 247, 217);
    text-decoration: none;
}

a:visited {
    font-family: "Bitter", serif;
    color: rgb(242, 247, 217);
    text-decoration: none;
}

a:active {
    text-decoration: none; 
}

li {
    list-style: none;
    
}

.list-block{
    display: flex;
    align-items: center;
}
</style>