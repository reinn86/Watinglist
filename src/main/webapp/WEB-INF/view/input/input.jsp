<%@ page contentType="text/html;charset=UTF-8" %>
    <!DOCTYPE html>
    <html lang="ja">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>順番待ち確認システム</title>
        <link rel="stylesheet" href="./assets/css/styles.css">
    </head>

    <body style="width: 100%; margin-top: 20px;margin-left: 20px;">        
        <div style="margin-bottom: 10px; width:50%;height: 800px; float: left; overflow: scroll;">
            <table border="solid" style="text-align: center; width: 100%;">
                <thead style="width: 100%;">
                    <tr>
                        <th>予約番号</th>
                        <th>注文個数</th>
                        <th>調理完了</th>
                    </tr>
                </thead>
                <tbody>
                    <%= application.getAttribute("orderListHtml") %>
                </tbody>
            </table>
        </div>
        <div style="width:50%; text-align: center; float: right; margin: 0 auto;">
            <!-- 追加 -->
            <form action="" method="post" style="margin-top: 10px;">
                <p>
                    <label>予約追加:
                        <input type="text" name="append" placeholder="注文する個数" tabindex="1">
                        <input type="submit" name="append" value="追加">
                    </label>
                </p>
            </form>
            
            <!-- 調理完了 -->
            <form action="" method="post" style="margin-top: 50px;">
                <p>
                    <label>調理完了:
                        <input type="text" name="complate" placeholder="調理完了番号" tabindex="2">
                        <input type="submit" name="complate" value="調理完了！">
                    </label>
                </p>
            </form>

            <!-- 完了-->
            <form action="" method="post" style="margin-top: 10px;">
                <p>
                    <label>受け取り済み:
                        <input type="text" name="receiptComplete" placeholder="受け取り済み番号" tabindex="3">
                        <input type="submit" name="receiptComplete" value="完了">
                    </label>
                </p>
            </form>
        
            <!-- キャンセル -->
            <form action="" method="post" style="margin-top: 10px;">
                <p>
                    <label>キャンセル:
                        <input type="text" name="cancel" placeholder="キャンセル番号" tabindex="4">
                        <input type="submit" name="cancel" value="キャンセル" style="background-color: RED;">
                    </label>
                </p>
            </form>
            <div style="margin-top: 200px; border: 1px solid;">
            <p>販売個数<strong style="font-size: 50pt;margin-top: 200px;"><%= application.getAttribute("unitSales") %></strong>個</p>
            <!-- <p>現在の売り上げ<strong style="font-size: 50pt;"><%= application.getAttribute("priceSum") %></strong>円</p> -->
            <p>あくまでおおよそです</p>
            </div>
            <!-- トップページに戻る
            <form action="" method="post" style="float: right; width: auto; margin-right: 1rem;">
                <input type="submit" name="home" value="トップページ">
            </form> -->
        </div>
    </body>

    </html>