<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
    </head>

    <body>
        <p>現在の順番待ちの人数</p>
        <p>
            <%= application.getAttribute("orderCount") %>人
        </p>

        <table border="1">
            <!-- <caption>順番待ちリスト</caption> -->
            <thead>
                <tr>
                    <th>調理中！</th>
                </tr>
            </thead>
            <tbody>
                <%= application.getAttribute("cookingNowList") %>
            </tbody>
        </table>

        <table border="1">
            <!-- <caption>調理完了リスト</caption> -->
            <thead>
                <tr>
                    <th>調理完了!</th>
                </tr>
            </thead>
            <tbody>
                <%= application.getAttribute("finishedCookingList") %>
            </tbody>
        </table>
    </body>

    </html>