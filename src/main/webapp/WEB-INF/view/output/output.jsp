<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
    </head>

    <body style="width: 100%;">
        <table style="float: left; width: 25%;">
            <!-- <caption>順番待ちリスト</caption> -->
            <thead style="background-color: blue; color: white; font-size: 2.5rem;">
                <tr>
                    <th>調理中！</th>
                </tr>
            </thead>
            <tbody style="color: blue; font-size: 2.5rem;">
                <%= application.getAttribute("cookingNowList") %>
            </tbody>
        </table>

        <table style="width: 25%;">
            <!-- <caption>調理完了リスト</caption> -->
            <thead style="background-color: pink; color: white; font-size: 2.5rem;">
                <tr>
                    <th>調理完了!</th>
                </tr>
            </thead>
            <tbody style="color: pink; font-size: 2.5rem;">
                <%= application.getAttribute("finishedCookingList") %>
            </tbody>
        </table>
        <footer style="position: absolute; bottom: 0px; margin-bottom: 10px; width: 100%;">
            <h2 style="font-size: 3.5rem;">ソースコード焼きそば現在 <%= application.getAttribute("orderCount") %>人 待ちです</h2>
            <!-- <h2 style="font-size: 3.5rem;">お手元の番号をご確認ください</h2> -->
        </footer>
    </body>
</html>