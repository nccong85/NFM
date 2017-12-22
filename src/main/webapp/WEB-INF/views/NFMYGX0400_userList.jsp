<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NFM輸送費計算システム</title>
<link rel="shortcut icon" href="../resources/images/ZP/ZPZZOL00/icon/favicon.ico" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>ユーザー検索</h2>
					</div>
				</div>
				<div class="alert alert-danger error-area" style="display: none;">
					<strong>エラーです。</strong>
				</div>
				<form id="NFMYGX0400" action="search" method="post">
					<input type="hidden" id="searchMode" value="${searchMode}">
					<input type="hidden" id="offset" name="offset" value="${offset}">
					<input type="hidden" id="rowPerPage" name="rowPerPage" value="${rowPerPage}">
					<input type="hidden" id="sortName" name="sortName" value="${sortName}">
					<input type="hidden" id="sortOrder" name="sortOrder" value="${sortOrder}">
					<input type="hidden" id="count" value="${count}">
					<div class="row">
						<div class="col-md-9 col-sm-12 col-xs-12">
							<section>
							<div class="navbar2">
								<div class="navbar2-inner">
									<span class="brand2">検索条件</span>
								</div>
							</div>
							</section>
							<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<td class="caption col-md-2 required">ユーザID</td>
									<td class="col-md-4">
										<input class="form-control input-small string-half" style="width: 200px;" type="text" name="searchUserId" />
									</td>
									<td class="caption col-md-2">氏名</td>
									<td class="col-md-4">
										<input class="form-control input-medium string-wide" style="width: 250px;" type="text" name="searchUserName" />
									</td>
								</tr>
								<tr>
									<td class="caption col-md-2">会社</td>
									<td class="">
										<input class="form-control input-medium" style="width: 250px;" type="text" name="searchUserKaishaName" />
									</td>
									<td class="caption col-md-2">部門</td>
									<td class="col-md-4">
										<input class="form-control input-medium string-wide" style="width: 250px;" type="text" name="searchUserSozoku" />
									</td>
								</tr>
								<tr>
									<td class="col-md-2 caption">メール</td>
									<td class="col-md-4">
										<input class="form-control input-medium string-half" type="text" style="width: 250px;" name="searchUserMail" />
									</td>
									<td class="col-md-2 caption">電話番号</td>
									<td class="col-md-4">
										<input class="form-control input-medium string-half" type="text" style="width: 150px;" name="searchUserTel" />
									</td>
								</tr>
							</table>
							<div align="right">
								<button class="btn btn-default searchButton" style="margin-top: 5px; margin-bottom: 5px;">
									<i class="ic-find"></i>検索
								</button>
							</div>
						</div>
					</div>
				</form>
				<div class="row paggingTest"></div>
				<div class="row">
					<table class="table-single col-md-9">
						<tr>
							<td class="col-md-6">
								<button type="button" class="btn btn-default">
									<i class="ic-delete-record"></i>削除
								</button>
							</td>
							<td class="col-md-3" align="right">
								<button type="button" class="btn btn-default addUserButton">
									<i class="ic-add-record"></i>新規登録
								</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default" id="userList">
							<table id="testTable" class="table-list table table-bordered table-striped table-hover table-condensed">
								<thead>
									<tr>
										<th>
											<input class="allCheck" value="" type="checkbox">
										</th>
										<th>
											ユーザID&nbsp;&nbsp;&nbsp;<i class="fa fa-sort" id="sortUserId" style="cursor: pointer;"></i>
										</th>
										<th>
											ユーザ名&nbsp;&nbsp;&nbsp;<i class="fa fa-sort" id="sortUserName" style="cursor: pointer;"></i>
										</th>
										<th>権限</th>
										<th>会社</th>
										<th>部門</th>
										<th>メール</th>
										<th>電話番号</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${userList}" var="item" varStatus="itr">
										<tr>
											<td class="parts">
												<input name="userCheck" value="" type="checkbox">
											</td>
											<td class="string">${item.userId}</td>
											<td class="string">${item.userName}</td>
											<td class="number">${item.sosaKengen}</td>
											<td class="string">${item.userKaishaName}</td>
											<td class="string">${item.userShozoku}</td>
											<td class="string">${item.userMail}</td>
											<td class="string">${item.userTel}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:url var="home" value="/" scope="request" />
	<script type="text/javascript">
		$(document).ready(function() {
			var offset = parseInt($("#offset").val());
			var rowPerPage = parseInt($("#rowPerPage").val());
			var count = parseInt($("#count").val());
			var searchMode = $("#searchMode").val();
			var html = createPaggingControl(searchMode, offset, count, rowPerPage, "userId", "ASC");
			$(".paggingTest").html(html);
		});

		function drawTable(data) {
			for (var i = 0; i < data.length; i++) {
				drawRow(data[i]);
			}
		}

		function drawRow(rowData) {
			var row = $("<tr />")
			$("#testTable > tbody").append(row);
			row.append($('<td class="parts">' + '<input class="detailCheck" value="" type="checkbox">' + "</td>"));
			row.append($("<td>" + rowData.userId + "</td>"));
			row.append($("<td>" + rowData.userName + "</td>"));
			row.append($("<td>" + rowData.sosaKengen + "</td>"));
			row.append($("<td>" + rowData.userKaishaName + "</td>"));
			row.append($("<td>" + rowData.userShozoku + "</td>"));
			row.append($("<td>" + rowData.userMail + "</td>"));
			row.append($("<td>" + rowData.userTel + "</td>"));
		}

		$(".searchButton").click(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var formObj = $('#NFMYGX0400');
			var formURL = formObj.attr("action");

			$.ajax({
			type : "POST",
			url : formURL,
			data : formObj.serialize(),
			success : function(data) {
				$("#testTable > tbody").html("");
				drawTable(data.result.userList);

				var offset = data.result.offset;
				var rowPerPage = data.result.rowPerPage;
				var count = data.result.count;
				var searchMode = data.result.searchMode;

				$("#searchMode").val(data.result.searchMode);
				$("#sortName").val(data.result.sortName);
				$("#sortOrder").val(data.result.sortOrder);
				$("#rowPerPage").val(data.result.rowPerPage);
				$("#offset").val(data.result.offset);

				var html = createPaggingControl(searchMode, offset, count, rowPerPage, "userId", "ASC");

				$(".paggingTest").html(html);

			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});

		});

		function changeRowPerPage() {
			var _offset = 0;
			var _rowPerPage = parseInt($(".rowPerPage option:selected").val());
			$("#rowPerPage").val(_rowPerPage);

			var _count = parseInt($("#count").val());
			var _searchMode = $("#searchMode").val();
			var _sortName = $("#sortName").val();
			var _sortOrder = $("#sortOrder").val();

			var _url = '';
			if (_searchMode == 'init') {
				_url = "${home}NFMYGX0400/paggingInit/";
			} else if (_searchMode == 'search') {
				_url = "${home}NFMYGX0400/paggingSearch/";
			}

			$.ajax({
			type : "POST",
			url : _url,
			data : {
			offset : _offset,
			rowPerPage : _rowPerPage,
			sortName : _sortName,
			sortOrder : _sortOrder
			},
			success : function(data) {
				$("#testTable > tbody").html("");
				drawTable(data.result.userList);
				var html = createPaggingControl(_searchMode, _offset, _count, _rowPerPage, _sortName, _sortOrder);

				$(".paggingTest").html(html);
			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		}
		function doPagging(methodName, _offset, _rowPerPage, _sortName, _sortOrder) {
			var _url = '';
			if (methodName == 'init') {
				_url = "${home}NFMYGX0400/paggingInit/";
			} else if (methodName == 'search') {
				_url = "${home}NFMYGX0400/paggingSearch/";
			}
			$.ajax({
			type : "POST",
			url : _url,
			data : {
			offset : _offset,
			rowPerPage : _rowPerPage,
			sortName : _sortName,
			sortOrder : _sortOrder
			},
			success : function(data) {
				var count = parseInt($("#count").val());
				var html = createPaggingControl(methodName, _offset, count, _rowPerPage, "userId", "ASC");

				$(".paggingTest").html(html);
				$("#testTable > tbody").html("");
				drawTable(data.result.userList);
			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		}

		function createPaggingControl(searchMode, offset, count, rowPerPage, sortName, sortOrder) {
			var html = '';
			html += '<table class="table-single col-md-9">';
			html += '<tr>';
			html += '<td class="col-md-3">全' + count + '件(1-' + rowPerPage + '件目を表示)</td>';
			html += '<td class="col-md-6" align="center">';
			html += '<ul class="pagination pagination-sm">';

			if (offset < rowPerPage) {
				html += constructLink(searchMode, 1, "&laquo;", "disabled", true, rowPerPage, sortName, sortOrder);
			} else {
				html += constructLink(searchMode, offset - rowPerPage, "&laquo;", null, false, rowPerPage, sortName, sortOrder);
			}

			for (var i = 0; i < count; i += rowPerPage) {
				if (offset == i) {
					html += constructLink(searchMode, (i / rowPerPage + 1) - rowPerPage, i / rowPerPage + 1, "active", true, rowPerPage, sortName, sortOrder);
				} else {
					html += constructLink(searchMode, i, i / rowPerPage + 1, null, false, rowPerPage, sortName, sortOrder);
				}
			}

			if (offset + rowPerPage >= count) {
				html += constructLink(searchMode, offset + rowPerPage, "&raquo;", "disabled", true, rowPerPage, sortName, sortOrder);
			} else {
				html += constructLink(searchMode, offset - rowPerPage, "&raquo;", null, false, rowPerPage, sortName, sortOrder);
			}
			html += '</ul>';
			html += '<td class="col-md-3" align="right">';
			html += '<select class="form-control input-sm rowPerPage" style="width:180px" onChange="changeRowPerPage();">';
			for (var i = 1; i <= 3; i++) {

				if (i == rowPerPage / 10) {
					html += '<option value="' + i * 10 + '" selected="selected"' + '>';
					html += i * 10 + '件/ページ</option>';
				} else {
					html += '<option value="' + i * 10 + '">';
					html += i * 10 + '件/ページ</option>';
				}
			}

			html += '</select> </td> </tr> </table>';

			return html;
		}

		function constructLink(searchMode, page, text, className, disabled, rowPerPage, sortName, sortOrder) {
			var link = '<li';
			if (className != null) {
				link += ' class="' + className + '"';
			}
			if (disabled) {
				link += '>';
				link += '<a href="#">' + text + '</a></li>';
			} else {
				link += '>';
				link += '<a href="#" onclick = "doPagging(&#39;' + searchMode + '&#39;,' + page + ',' + rowPerPage + ',&#39;' + sortName + '&#39;,&#39;' + sortOrder + '&#39;);">' + text + '</a></li>';
			}

			return link;
		}
	</script>
</body>
</html>