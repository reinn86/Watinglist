<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
        <link rel="stylesheet" type="text/css" href="./assets/css/styles.css">
    </head>

    <body>
        <img src="./assets/images/uzumaki.png" class="uzumaki_border">
        <table class="waiting_table">
            <!-- <caption>順番待ちリスト</caption> -->
            <thead>
                <tr>
                    <th>現在 <%= application.getAttribute("orderCount") %>人 待ち</th>
                </tr>
            </thead>
            <tbody style="width: 50%;float: left;">
                <%= application.getAttribute("cookingNowList1") %>
            </tbody>
            <tbody style="width: 50%;float:right;">
                <%= application.getAttribute("cookingNowList2") %>
            </tbody>
        </table>

        <table class="cooked_table">
            <!-- <caption>調理完了リスト</caption> -->
            <thead style="background-color: pink; color: white; font-size: 2.5rem;">
                <tr>
                    <th>完成しました!</th>
                </tr>
            </thead>
            <tbody style="color: pink; font-size: 2.5rem;">
                <%= application.getAttribute("finishedCookingList") %>
            </tbody>
        </table>
        <footer style="position: absolute; bottom: 0px;width: 100%;">
            <img src="./assets/images/uzumaki.png" class="uzumaki_border">
        </footer>
    </body>
</html>