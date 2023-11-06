<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="refresh" content="10; URL=https://4e63-122-216-134-29.ngrok-free.app/WatingList/output">
        <title>順番待ち確認システム</title>
        <link rel="stylesheet" type="text/css" href="./assets/css/styles.css">
    </head>

    <body class="output_scene">
        <header style="height: 10vh;">
            <img src="./assets/images/uzumaki.png" class="uzumaki_border">
        </header>
        <main style="height: 80vh;">
            <table class="waiting_table">
                <!-- <caption>順番待ちリスト</caption> -->
                <thead>
                    <tr>
                        <th>現在<a style="font-size: 3.5rem;"> <%= application.getAttribute("orderCount") %>人</a> 待ち</th>
                    </tr>
                </thead>
                <tbody style="width: 49%; float: left; border-right: 1px solid black;">
                    <%= application.getAttribute("cookingNowList1") %>
                </tbody>
                <tbody style="width: 50%;float:right;">
                    <%= application.getAttribute("cookingNowList2") %>
                </tbody>
            </table>
    
            <table class="cooked_table">
                <!-- <caption>調理完了リスト</caption> -->
                <thead>
                    <tr>
                        <th>完成しました!!</th>
                    </tr>
                </thead>
                <tbody style="float: left;">
                    <%= application.getAttribute("finishedCookingList") %>
                    <tr style="height: auto;"></tr>
                </tbody>
            </table>
        </main>
        
        <footer style="height: 10vh;">
            <img src="./assets/images/uzumaki.png" class="uzumaki_border">
        </footer>
    </body>
</html>