<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>NF&amp;M輸送費計算システム</title>
	<link rel="Shortcut icon" href="assets/images/ZP/ZPZZ/ZPZZOL00/icon/favicon.ico" type="image/x-icon" />
	<!-- IMPORT CSS-->
	<link href="../resources/css/import.css" rel="stylesheet">
	<!-- GOOGLE FONTS-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
	<script src="../resources/js/import.js"></script>
	<script>
		// ページの初期化
		$(document).ready(function() {
		});

		$(".logoutButton").click(function() {
			$.confirmMsgBox("ログアウトしますか？", function() {
				location.href = "NFMYBX0010";
			});
		});
	</script>
	
</head>

<!-- I'm a main view -->
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>お知らせ情報</h2>
					</div>
				</div>
				<div class="alert alert-danger error-area" style="display: none;">
					<strong>エラーです。</strong>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<table
								class="table-list table table-bordered table-striped table-hover table-condensed">
								<thead>
									<tr>
										<th>内容<i class="fa fa-sort"></i></th>
										<th>担当</th>
										<th>日時</th>
										<th>版</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="string">・テキストボックスのStyleを追加（input.string,input.date,input.parts)</br>
										</td>
										<td class="string">CongF</td>
										<td class="date">2016/08/24</td>
										<td class="string">2.2</td>
									</tr>
									<tr>
										<td class="string">・テキストボックスのStyleを追加（input-xsmall,input-small等)</br>
											・ログイン画面を追加</br>
										</td>
										<td class="string">CongF</td>
										<td class="date">2016/08/16</td>
										<td class="string">2.1</td>
									</tr>
									<tr>
										<td class="string">・全画面レイオウトを更新</br> ・カレンダPluginを追加</br>
											・コンテストメニューを追加</br> ・カストマーメッセージボックスを追加</br> ・IconのCSSを追加</br>
											・Modalダイアログの不具合を修正（ScrollBarが表示してしまう）</br> ・必須マーク（＊）を追加</br>
										</td>
										<td class="string">CongF</td>
										<td class="date">2016/08/15</td>
										<td class="string">2.0</td>
									</tr>
									<tr>
										<td class="string">・CSSを更新</td>
										<td class="string">CongF</td>
										<td class="date">2016/07/18</td>
										<td class="string">1.2</td>
									</tr>
									<tr>
										<td class="string">・一覧にソートアイコンを追加</td>
										<td class="string">CongF</td>
										<td class="date">2016/07/18</td>
										<td class="string">1.1</td>
									</tr>
									<tr>
										<td class="string">・指摘内容の反映</td>
										<td class="string">CongF</td>
										<td class="date">2016/07/18</td>
										<td class="string">1.0</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<div id="dialog">
		<!-- Modal -->
	</div>
	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/import.js"></script>
	<script>
		// ページの初期化
		$(document).ready(function() {
		});

		$(".logoutButton").click(function() {
			$.confirmMsgBox("ログアウトしますか？", function() {
				location.href = "login.html";
			});
		});
	</script>
</body>
</html>