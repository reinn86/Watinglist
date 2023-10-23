<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
    </head>

    <body>
        <table border="1" style="float: left;">
            <!-- <caption>順番待ちリスト</caption> -->
            <thead style="color: blue;">
                <tr>
                    <th>調理中！</th>
                </tr>
            </thead>
            <tbody style="color: blue;">
                <%= application.getAttribute("cookingNowList") %>
            </tbody>
        </table>

        <table border="1">
            <!-- <caption>調理完了リスト</caption> -->
            <thead style="color: pink;">
                <tr>
                    <th>調理完了!</th>
                </tr>
            </thead>
            <tbody style="color: pink;">
                <%= application.getAttribute("finishedCookingList") %>
            </tbody>
        </table>
        <footer style="position: absolute; bottom: 0px; margin-bottom: 10px;">
            <h2>現在<%= application.getAttribute("orderCount") %>人待ち</h2>
            <h2>番号をご確認ください</h2>
        </footer>
    </body>
</html>