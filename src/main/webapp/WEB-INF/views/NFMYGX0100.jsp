<%@page import="vn.com.nsmv.common.MessageIdConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>NF&amp;M輸送費計算システム</title>
</head>
<!-- I'm a search sojo view -->
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>輸送費検索</h2>
					</div>
				</div>
				<!-- START SEARCH -->
				<form:form role="form" action="search" modelAttribute="NFMYGX0100_SearchBean" id="NFMYGX0100">
					<c:set var="er">
						<form:errors path="*" />
					</c:set>
					<c:if test="${not empty er}">
						<div style="color: red; font-size: 13px; margin-bottom: 5px">${er}</div>
					</c:if>
					<div id="NFMYGX0100_BusinessMessage" style="color: red; font-size: 13px; font-weight: bold; margin-bottom: 5px">${businessMessage}</div>
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
									<td class="caption col-md-2">送状番号</td>
									<td class="form-inline col-md-4">
										<form:input id="sojonoShukkoBasho" path="searchSojoNoShukkoBasho" maxlength="3" class="form-control input-sm" type="text"
											style="width: 60px;" tabindex="1001" />
										<form:input id="sojoNoTorihikiShubetsu" path="searchSojoNoTorihikiShubetsu" maxlength="1" class="form-control input-sm" type="text"
											style="width: 40px;" tabindex="1002" />
										<form:input id="sojonoOban" path="searchSojoNoOban" maxlength="5" class="form-control input-sm" type="text" style="width: 80px;"
											tabindex="1003" />
									</td>
									<td class="caption col-md-2">出荷日</td>
									<td class="form-inline col-md-4">
										<div class="input-daterange input-group" id="datepicker">
											<form:input id="shukkadatefrom" path="searchShukkaFromDate" type="text" class="input-sm form-control" tabindex="1004" />
											<span class="input-group-addon">～</span>
											<form:input id="shukkadateto" path="searchShukkaToDate" type="text" class="input-sm form-control" tabindex="1005" />
										</div>
									</td>
								</tr>
								<tr>
									<td class="caption col-md-2">受渡場所</td>
									<td>
										<form:input id="watashibasho" path="searchUkewatashiBasho" maxlength="4" class="form-control input-sm" type="text"
											style="width: 120px; text-transform:uppercase;" tabindex="1006" />
									</td>
									<td class="caption col-md-2">輸送業者</td>
									<td class="col-md-4">
										<form:input id="gyoushacd" path="searchYusoGyoshaCd" maxlength="3" class="form-control input-sm" type="text" style="width: 90px;"
											tabindex="1007" />
									</td>
								</tr>
								<tr>
									<td class="col-md-2 caption">費目</td>
									<td class="col-md-4">
										<form:input id="himokucd" path="searchHimokuCd" maxlength="2" class="form-control input-sm" type="text"
											style="width: 60px; ime-mode:disabled; text-transform:uppercase;" tabindex="1008" />
									</td>
									<td class="col-md-2 caption">積合</td>
									<td class="col-md-4">
										<form:input id="tsumiawasecd" path="searchTsumiaiCd" maxlength="2" class="form-control input-sm" type="text"
											style="width: 90px; ime-mode:disabled;" tabindex="1009" />
									</td>
								</tr>
								<tr>
									<td class="col-md-2 caption">請求年月</td>
									<td class="col-md-4">
										<form:input id="seikyunengetsu" path="searchSeikyuYearMonth" maxlength="6" class="form-control input-sm" type="text" style="width: 90px;"
											tabindex="1010" />
									</td>
									<td class="col-md-2 caption">出力順</td>
									<td class="col-md-4">
										<label class="radio-inline">
											<form:radiobutton path="sortSelect" value="0" tabindex="1011" checked/>
											送状番号
										</label>
										<label class="radio-inline">
											<form:radiobutton path="sortSelect" value="1" />
											出荷日・積合
										</label>
									</td>
								</tr>
							</table>
							<div align="right">
								<button id="searchButton" type="submit" class="btn btn-default searchButton"
									style="margin-top: 5px; margin-bottom: 5px;" tabindex="1011">
									<i class="ic-find"></i>検索
								</button>
							</div>
						</div>
					</div>
				</form:form>
				<!-- END SEARCH -->
				<div class="row" style="margin-bottom: 5px;">
					<table class="table-single col-md-9">
						<tr>
							<td class="col-md-3" align="right">
								<button type="button" class="btn btn-default addNewYusohi">
									<i class="ic-add-record"></i>新規登録
								</button>
							</td>
						</tr>
					</table>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<table class="table-list table table-bordered table-condensed" id="myTable">
								<thead>
									<tr>
										<th>計算状況</th>
										<th>送状番号</th>
										<th>出荷日</th>
										<th>請求年月</th>
										<th>便コード</th>
										<th>出庫場所</th>
										<th>受渡場所</th>
										<th>業者コード</th>
										<th>積合</th>
										<th>台数</th>
										<th>重量</th>
										<th>費目</th>
										<th>単価単位</th>
										<th>単価</th>
										<th>金額</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${searchResultList}" varStatus="sojoDataCOCount">
										<c:forEach var="sojoHimokuDataCO" items="${item.sojoHimokuDataCOList}" varStatus="sojoHimokuDataCOCount">
											<c:choose>
												<c:when test="${sojoHimokuDataCOCount.index == 0}">
													<tr id="${sojoDataCOCount.index}">
														<td rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.keisanStatus}</td>
														<td rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.sojonoShukkoBasho}-${item.sojonoTorihikiShubetsu}-${item.sojonoOban}</td>
														<td class="date" rowspan="${fn:length(item.sojoHimokuDataCOList)}">
															<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
															<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
														</td>
														<td class="date" rowspan="${fn:length(item.sojoHimokuDataCOList)}">
															<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedseikyuNengetsu" pattern="yyyyMM" />
															<fmt:formatDate pattern="yyyy/MM" value="${parsedseikyuNengetsu}" />
														</td>
														<td class="parts" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.bincd}</td>
														<td class="parts" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.shukkoBasho}</td>
														<td class="parts" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.ukewatashiBasho}</td>
														<td class="parts" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.gyoshaCd}</td>
														<td class="parts" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.tsumiaicd}</td>
														<td class="number" rowspan="${fn:length(item.sojoHimokuDataCOList)}">${item.daisu}</td>
														<td class="number" rowspan="${fn:length(item.sojoHimokuDataCOList)}">
															<fmt:formatNumber type="number" value="${item.juryo}" />
														</td>
														<td class="parts">${sojoHimokuDataCO.himokucd}</td>
														<td class="parts">${sojoHimokuDataCO.tankaTani}</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${sojoHimokuDataCO.tanka}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${sojoHimokuDataCO.kingaku}" />
														</td>
													</tr>
												</c:when>
												<c:otherwise>
													<tr>
														<td class="parts">${sojoHimokuDataCO.himokucd}</td>
														<td class="parts">${sojoHimokuDataCO.tankaTani}</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${sojoHimokuDataCO.tanka}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${sojoHimokuDataCO.kingaku}" />
														</td>
													</tr>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										<input type="hidden" id="sojonoShukkoBasho${sojoDataCOCount.index}" value='${item.sojonoShukkoBasho}'>
										<input type="hidden" id="sojonoTorihikiShubetsu${sojoDataCOCount.index}" value='${item.sojonoTorihikiShubetsu}'>
										<input type="hidden" id="sojonoOban${sojoDataCOCount.index}" value='${item.sojonoOban}'>
										<input type="hidden" id="sojonoRenban${sojoDataCOCount.index}" value='${item.sojonoRenban}'>
										<input type="hidden" id="seikyuNengetsu${sojoDataCOCount.index}" value='${item.seikyuNengetsu}'>
										<input type="hidden" id="headTeiseiKbn${sojoDataCOCount.index}" value='${item.headTeiseiKbn}'>
										<input type="hidden" id="headTeiseiKaisu${sojoDataCOCount.index}" value='${item.headTeiseiKaisu}'>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<ul id="nfmygx0100Menu" class="contextMenu">
				<li><a tabindex="-1" href="#g1"><i class="ic-refer-record"></i>照会</a></li>
				<li><a tabindex="-1" href="#g2"><i class="ic-edit-record"></i>訂正</a></li>
				<li><a tabindex="-1" href="#g3"><i class="ic-edit-record"></i>修正</a></li>
				<li><a tabindex="-1" href="#g4"><i class="ic-delete-record"></i>削除</a></li>
			</ul>
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<script>
		//$(".error-area").hide();

		/* 	$(".searchButton").click(function() {
				$.infoMsgBox("検索条件が入力されていません。");
			}); */

		$(".addNewYusohi").click(function() {
			$('#NFMYGX0100').attr('action', "add");
			$("#NFMYGX0100").submit();
		});

		// コンテキストメニュー
		$("table.table-list tbody tr").contextMenu({
			menu : 'nfmygx0100Menu'
		}, function(action, el, pos) {
			// When click 照会(View)
			if (action == "g1") {
				row = $(el).closest("tr");
				value = $(el).closest("tr").find("td").eq(0).text();
				if (value == "計算前") {
					callMedthod("view", row);
				} else if (value == "計算後") {
					callMedthod("viewYusohi", row);
				} else {
					findFirstRowWhenRowSpan(row);
				}

				// When click 訂正(Edit)
			} else if (action == "g2") {
				row = $(el).closest("tr");
				value = $(el).closest("tr").find("td").eq(0).text();
				if (value == "計算前") {
					callMedthod('edit', row);

				} else if (value == "計算後") {
				}

			} else if (action == "g3") {
				row = $(el).closest("tr");
				value = $(el).closest("tr").find("td").eq(0).text();

				if (value == "計算前") {
				} else if (value == "計算後") {
					callMedthod('directEdit', row);
				}
			} else if (action == "g4") {
				// 削除
				alert("delete");
			}
		});
		function findFirstRowWhenRowSpan(row) {
			for (var i = 0; i < 8; i++) {
				value = row.find("td").eq(0).text();

				if (value == "計算前") {
					alert(row.find("td").eq(1).text());
					break;
				} else if (value == "計算後") {
					alert(row.find("td").eq(1).text());
					break;
				} else {
					row = row.prev();
				}
			}
		}

		function callMedthod(methodName, row) {
			id = row.attr('id');

			var sojonoShukkoBasho = $("#sojonoShukkoBasho" + id).val();
			var sojonoTorihikiShubetsu = $("#sojonoTorihikiShubetsu" + id).val();
			var sojonoOban = $("#sojonoOban" + id).val();
			var sojonoRenban = $("#sojonoRenban" + id).val();
			var sojoNo = sojonoShukkoBasho + "-" + sojonoTorihikiShubetsu + "-" + sojonoOban;
			var sojoNoWithRenban = sojonoShukkoBasho + "-" + sojonoTorihikiShubetsu + "-" + sojonoOban + "-" + sojonoRenban;

			if (methodName == 'view') {
				$(location).attr('href', '<c:url value= "/NFMYGX0110/init/'+sojoNo+'"/>');
			} else if (methodName == 'viewYusohi') {
				$(location).attr('href', '<c:url value= "/NFMYGX0150/view/'+sojoNoWithRenban+'"/>');
			} else if (methodName == 'edit') {
				$(location).attr('href', '<c:url value= "/NFMYGX0130/edit/'+sojoNo+'"/>');
			} else if (methodName == 'directEdit') {
				$(location).attr('href', '<c:url value= "/NFMYGX0140/init/'+sojoNoWithRenban+'"/>');
			}
		}
	</script>
</body>
</html>