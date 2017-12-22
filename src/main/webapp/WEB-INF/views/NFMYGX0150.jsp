<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NF&amp;M輸送費計算システム</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<form id="NFMYGX0150" method="post">
			<input id="historyShowMode" type="hidden" />
			<input id="viewMode" type="hidden" value="${viewMode}" />
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<h2>輸送費照会</h2>
						</div>
					</div>
					<div id="NFMYGX0150_BusinessMessage" class="businessMessageStyle">${businessMessage}</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<td class="caption col-md-2">送状番号</td>
									<td class="col-md-10">${sojoNo.sojoNoShukkoBasho}-${sojoNo.sojoNoTorihikiShubetsu}-${sojoNo.sojoNoOban}</td>
								</tr>
							</table>
						</div>
					</div>
					<br>
					<div class="row" id="singleBinMode">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<h5>輸送情報</h5>
							<div class="panel panel-default">
								<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
									<thead>
										<tr>
											<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
											<th rowspan="2" style="vertical-align: middle;">出荷日</th>
											<th rowspan="2" style="vertical-align: middle;">契約番号</th>
											<th rowspan="2" style="vertical-align: middle;">需要家</th>
											<th rowspan="2" style="vertical-align: middle;">便コード</th>
											<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
											<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
											<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
											<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
											<th rowspan="2" style="vertical-align: middle;">積合コード</th>
											<th rowspan="2" style="vertical-align: middle;">台数</th>
											<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
											<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
											<th rowspan="2" style="vertical-align: middle;">金額</th>
										</tr>
										<tr>
											<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
											<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${singleBinYusohi.headInfoList}" varStatus="headData">
											<c:choose>
												<c:when test="${item.keirikiFlg == '1'}">
													<c:set var="rirekiClass" value="teiseiRireki" />
												</c:when>
												<c:otherwise>
													<c:set var="rirekiClass" value="" />
												</c:otherwise>
											</c:choose>
											<tr class="${rirekiClass}">
												<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
												<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
												<td class="date">
													<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
													<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
												</td>
												<td>${item.keiyakuNo}</td>
												<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
												<td>${item.bincd}<br>${item.bincdName}</td>
												<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
												<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
												<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
												<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
												<td>${item.tsumiaicd}</td>
												<td>${item.daisu}</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.juryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.kyori}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.kingaku}" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<div class="col-md-12 col-sm-12 col-xs-12">
							<h5>費目明細情報</h5>
							<div class="panel panel-default">
								<table class="tblxyz table-list table table-bordered table-condensed">
									<thead>
										<tr>
											<th colspan="2" class="teiseiRireki">訂正</th>
											<th rowspan="2" style="vertical-align: middle;">費目</th>
											<th rowspan="2" style="vertical-align: middle;">業者</th>
											<th rowspan="2" style="vertical-align: middle;">請求年月</th>
											<th rowspan="2" style="vertical-align: middle;">単位単価</th>
											<th rowspan="2" style="vertical-align: middle;">単価</th>
											<th colspan="5">内訳情報</th>
											<th>重量</th>
											<th rowspan="2" style="vertical-align: middle;">内訳</th>
										</tr>
										<tr>
											<th style="" class="teiseiRireki">回数</th>
											<th class="teiseiRireki">区分</th>
											<th>基本</th>
											<th>空トン</th>
											<th>長尺</th>
											<th>休日</th>
											<th>時間外</th>
											<th>金額</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${singleBinYusohi.bodyInfoList}" varStatus="bodyData">
											<c:choose>
												<c:when test="${item.bodyKeirikiFlag == '1'}">
													<c:set var="rirekiClass" value="teiseiRireki" />
												</c:when>
												<c:otherwise>
													<c:set var="rirekiClass" value="" />
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
													<c:set var="showUchiwake" value="show" />
												</c:when>
												<c:otherwise>
													<c:set var="showUchiwake" value="none" />
												</c:otherwise>
											</c:choose>
											<tr class="${rirekiClass}">
												<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
												<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
												<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
												<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
												<td rowspan="2" class="date">
													<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
													<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
												</td>
												<td rowspan="2" class="parts">${item.tankaTani}</td>
												<td rowspan="2" class="number">
													<fmt:formatNumber type="number" value="${item.tanka}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number"
														value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
												</td>
												<td rowspan="2">
													<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
												</td>
											</tr>
											<tr class="${rirekiClass}">
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
												</td>
												<td class="number">
													<fmt:formatNumber type="number"
														value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<div class="row" id="multiBinMode">
						<input id="activeTab" type="hidden" value="${multiBinYusohi.activeTab}" />
						<div class="col-md-12 col-sm-12 col-xs-12">
							<c:choose>
								<c:when test="${multiBinYusohi.binCd1 == ''}">
									<c:set var="tab1Show" value="none" />
								</c:when>
								<c:otherwise>
									<c:set var="tab1Show" value="show" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${multiBinYusohi.binCd2 == ''}">
									<c:set var="tab2Show" value="none" />
								</c:when>
								<c:otherwise>
									<c:set var="tab2Show" value="show" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${multiBinYusohi.binCd3 == ''}">
									<c:set var="tab3Show" value="none" />
								</c:when>
								<c:otherwise>
									<c:set var="tab3Show" value="show" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${multiBinYusohi.binCd4 == ''}">
									<c:set var="tab4Show" value="none" />
								</c:when>
								<c:otherwise>
									<c:set var="tab4Show" value="show" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${multiBinYusohi.binCd5 == ''}">
									<c:set var="tab5Show" value="none" />
								</c:when>
								<c:otherwise>
									<c:set var="tab5Show" value="show" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${multiBinYusohi.activeTab == '0'}">
									<c:set var="tab1Active" value="active" />
									<c:set var="tab2Active" value="" />
									<c:set var="tab3Active" value="" />
									<c:set var="tab4Active" value="" />
									<c:set var="tab5Active" value="" />
								</c:when>
								<c:when test="${multiBinYusohi.activeTab == '1'}">
									<c:set var="tab1Active" value="" />
									<c:set var="tab2Active" value="active" />
									<c:set var="tab3Active" value="" />
									<c:set var="tab4Active" value="" />
									<c:set var="tab5Active" value="" />
								</c:when>
								<c:when test="${multiBinYusohi.activeTab == '2'}">
									<c:set var="tab1Active" value="" />
									<c:set var="tab2Active" value="" />
									<c:set var="tab3Active" value="active" />
									<c:set var="tab4Active" value="" />
									<c:set var="tab5Active" value="" />
								</c:when>
								<c:when test="${multiBinYusohi.activeTab == '3'}">
									<c:set var="tab1Active" value="" />
									<c:set var="tab2Active" value="" />
									<c:set var="tab3Active" value="" />
									<c:set var="tab4Active" value="active" />
									<c:set var="tab5Active" value="" />
								</c:when>
								<c:when test="${multiBinYusohi.activeTab == '4'}">
									<c:set var="tab1Active" value="" />
									<c:set var="tab2Active" value="" />
									<c:set var="tab3Active" value="" />
									<c:set var="tab4Active" value="" />
									<c:set var="tab5Active" value="active" />
								</c:when>
								<c:otherwise>
									<c:set var="tab1Active" value="active" />
									<c:set var="tab2Active" value="" />
									<c:set var="tab3Active" value="" />
									<c:set var="tab4Active" value="" />
									<c:set var="tab5Active" value="" />
								</c:otherwise>
							</c:choose>
							<ul class="nav nav-tabs">
								<li class="${tab1Active}" style="display: ${tab1Show};"><a href="#renban1" data-toggle="tab">${multiBinYusohi.binCd1}</a></li>
								<li class="${tab2Active}" style="display: ${tab2Show};"><a href="#renban2" data-toggle="tab">${multiBinYusohi.binCd2}</a></li>
								<li class="${tab3Active}" style="display: ${tab3Show};"><a href="#renban3" data-toggle="tab">${multiBinYusohi.binCd3}</a></li>
								<li class="${tab4Active}" style="display: ${tab4Show};"><a href="#renban4" data-toggle="tab">${multiBinYusohi.binCd4}</a></li>
								<li class="${tab5Active}" style="display: ${tab5Show};"><a href="#renban5" data-toggle="tab">${multiBinYusohi.binCd5}</a></li>
								<li class="gokeiTab"><a href="#gokei" data-toggle="tab">合計</a></li>
							</ul>
							<div class="tab-content">
								<div id="renban1">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>輸送情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
													<thead>
														<tr>
															<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">出荷日</th>
															<th rowspan="2" style="vertical-align: middle;">契約番号</th>
															<th rowspan="2" style="vertical-align: middle;">需要家</th>
															<th rowspan="2" style="vertical-align: middle;">便コード</th>
															<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
															<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
															<th rowspan="2" style="vertical-align: middle;">積合コード</th>
															<th rowspan="2" style="vertical-align: middle;">台数</th>
															<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
															<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
															<th rowspan="2" style="vertical-align: middle;">金額</th>
														</tr>
														<tr>
															<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
															<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.headInfoList1}" varStatus="headData">
															<c:choose>
																<c:when test="${item.keirikiFlg == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td class="date">
																	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
																	<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
																</td>
																<td>${item.keiyakuNo}</td>
																<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
																<td>${item.bincd}<br>${item.bincdName}</td>
																<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
																<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
																<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
																<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
																<td>${item.tsumiaicd}</td>
																<td>${item.daisu}</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.juryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kyori}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<h5>費目明細情報</h5>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="tblxyz table-list table table-bordered table-condensed">
													<thead>
														<tr>
															<th colspan="2" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">費目</th>
															<th rowspan="2" style="vertical-align: middle;">業者</th>
															<th rowspan="2" style="vertical-align: middle;">請求年月</th>
															<th rowspan="2" style="vertical-align: middle;">単位単価</th>
															<th rowspan="2" style="vertical-align: middle;">単価</th>
															<th colspan="5">内訳情報</th>
															<th>重量</th>
															<th rowspan="2" style="vertical-align: middle;">内訳</th>
														</tr>
														<tr>
															<th style="" class="teiseiRireki">回数</th>
															<th class="teiseiRireki">区分</th>
															<th>基本</th>
															<th>空トン</th>
															<th>長尺</th>
															<th>休日</th>
															<th>時間外</th>
															<th>金額</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.bodyInfoList1}" varStatus="bodyData">
															<c:choose>
																<c:when test="${item.bodyKeirikiFlag == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
																	<c:set var="showUchiwake" value="show" />
																</c:when>
																<c:otherwise>
																	<c:set var="showUchiwake" value="none" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
																<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
																<td rowspan="2" class="date">
																	<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
																	<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
																</td>
																<td rowspan="2" class="parts">${item.tankaTani}</td>
																<td rowspan="2" class="number">
																	<fmt:formatNumber type="number" value="${item.tanka}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td rowspan="2">
																	<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
																</td>
															</tr>
															<tr class="${rirekiClass}">
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div id="renban2">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>輸送情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
													<thead>
														<tr>
															<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">出荷日</th>
															<th rowspan="2" style="vertical-align: middle;">契約番号</th>
															<th rowspan="2" style="vertical-align: middle;">需要家</th>
															<th rowspan="2" style="vertical-align: middle;">便コード</th>
															<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
															<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
															<th rowspan="2" style="vertical-align: middle;">積合コード</th>
															<th rowspan="2" style="vertical-align: middle;">台数</th>
															<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
															<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
															<th rowspan="2" style="vertical-align: middle;">金額</th>
														</tr>
														<tr>
															<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
															<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.headInfoList2}" varStatus="headData">
															<c:choose>
																<c:when test="${item.keirikiFlg == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td class="date">
																	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
																	<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
																</td>
																<td>${item.keiyakuNo}</td>
																<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
																<td>${item.bincd}<br>${item.bincdName}</td>
																<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
																<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
																<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
																<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
																<td>${item.tsumiaicd}</td>
																<td>${item.daisu}</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.juryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kyori}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<h5>費目明細情報</h5>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="tblxyz table-list table table-bordered table-condensed">
													<thead>
														<tr>
															<th colspan="2" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">費目</th>
															<th rowspan="2" style="vertical-align: middle;">業者</th>
															<th rowspan="2" style="vertical-align: middle;">請求年月</th>
															<th rowspan="2" style="vertical-align: middle;">単位単価</th>
															<th rowspan="2" style="vertical-align: middle;">単価</th>
															<th colspan="5">内訳情報</th>
															<th>重量</th>
															<th rowspan="2" style="vertical-align: middle;">内訳</th>
														</tr>
														<tr>
															<th style="" class="teiseiRireki">回数</th>
															<th class="teiseiRireki">区分</th>
															<th>基本</th>
															<th>空トン</th>
															<th>長尺</th>
															<th>休日</th>
															<th>時間外</th>
															<th>金額</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.bodyInfoList2}" varStatus="bodyData">
															<c:choose>
																<c:when test="${item.bodyKeirikiFlag == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
																	<c:set var="showUchiwake" value="show" />
																</c:when>
																<c:otherwise>
																	<c:set var="showUchiwake" value="none" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
																<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
																<td rowspan="2" class="date">
																	<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
																	<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
																</td>
																<td rowspan="2" class="parts">${item.tankaTani}</td>
																<td rowspan="2" class="number">
																	<fmt:formatNumber type="number" value="${item.tanka}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td rowspan="2">
																	<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
																</td>
															</tr>
															<tr class="${rirekiClass}">
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div id="renban3">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>輸送情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
													<thead>
														<tr>
															<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">出荷日</th>
															<th rowspan="2" style="vertical-align: middle;">契約番号</th>
															<th rowspan="2" style="vertical-align: middle;">需要家</th>
															<th rowspan="2" style="vertical-align: middle;">便コード</th>
															<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
															<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
															<th rowspan="2" style="vertical-align: middle;">積合コード</th>
															<th rowspan="2" style="vertical-align: middle;">台数</th>
															<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
															<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
															<th rowspan="2" style="vertical-align: middle;">金額</th>
														</tr>
														<tr>
															<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
															<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.headInfoList3}" varStatus="headData">
															<c:choose>
																<c:when test="${item.keirikiFlg == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td class="date">
																	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
																	<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
																</td>
																<td>${item.keiyakuNo}</td>
																<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
																<td>${item.bincd}<br>${item.bincdName}</td>
																<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
																<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
																<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
																<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
																<td>${item.tsumiaicd}</td>
																<td>${item.daisu}</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.juryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kyori}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<h5>費目明細情報</h5>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="tblxyz table-list table table-bordered table-condensed">
													<thead>
														<tr>
															<th colspan="2" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">費目</th>
															<th rowspan="2" style="vertical-align: middle;">業者</th>
															<th rowspan="2" style="vertical-align: middle;">請求年月</th>
															<th rowspan="2" style="vertical-align: middle;">単位単価</th>
															<th rowspan="2" style="vertical-align: middle;">単価</th>
															<th colspan="5">内訳情報</th>
															<th>重量</th>
															<th rowspan="2" style="vertical-align: middle;">内訳</th>
														</tr>
														<tr>
															<th style="" class="teiseiRireki">回数</th>
															<th class="teiseiRireki">区分</th>
															<th>基本</th>
															<th>空トン</th>
															<th>長尺</th>
															<th>休日</th>
															<th>時間外</th>
															<th>金額</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.bodyInfoList3}" varStatus="bodyData">
															<c:choose>
																<c:when test="${item.bodyKeirikiFlag == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
																	<c:set var="showUchiwake" value="show" />
																</c:when>
																<c:otherwise>
																	<c:set var="showUchiwake" value="none" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
																<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
																<td rowspan="2" class="date">
																	<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
																	<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
																</td>
																<td rowspan="2" class="parts">${item.tankaTani}</td>
																<td rowspan="2" class="number">
																	<fmt:formatNumber type="number" value="${item.tanka}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td rowspan="2">
																	<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
																</td>
															</tr>
															<tr class="${rirekiClass}">
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div id="renban4">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>輸送情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
													<thead>
														<tr>
															<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">出荷日</th>
															<th rowspan="2" style="vertical-align: middle;">契約番号</th>
															<th rowspan="2" style="vertical-align: middle;">需要家</th>
															<th rowspan="2" style="vertical-align: middle;">便コード</th>
															<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
															<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
															<th rowspan="2" style="vertical-align: middle;">積合コード</th>
															<th rowspan="2" style="vertical-align: middle;">台数</th>
															<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
															<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
															<th rowspan="2" style="vertical-align: middle;">金額</th>
														</tr>
														<tr>
															<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
															<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.headInfoList4}" varStatus="headData">
															<c:choose>
																<c:when test="${item.keirikiFlg == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td class="date">
																	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
																	<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
																</td>
																<td>${item.keiyakuNo}</td>
																<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
																<td>${item.bincd}<br>${item.bincdName}</td>
																<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
																<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
																<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
																<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
																<td>${item.tsumiaicd}</td>
																<td>${item.daisu}</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.juryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kyori}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<h5>費目明細情報</h5>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="tblxyz table-list table table-bordered table-condensed">
													<thead>
														<tr>
															<th colspan="2" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">費目</th>
															<th rowspan="2" style="vertical-align: middle;">業者</th>
															<th rowspan="2" style="vertical-align: middle;">請求年月</th>
															<th rowspan="2" style="vertical-align: middle;">単位単価</th>
															<th rowspan="2" style="vertical-align: middle;">単価</th>
															<th colspan="5">内訳情報</th>
															<th>重量</th>
															<th rowspan="2" style="vertical-align: middle;">内訳</th>
														</tr>
														<tr>
															<th style="" class="teiseiRireki">回数</th>
															<th class="teiseiRireki">区分</th>
															<th>基本</th>
															<th>空トン</th>
															<th>長尺</th>
															<th>休日</th>
															<th>時間外</th>
															<th>金額</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.bodyInfoList4}" varStatus="bodyData">
															<c:choose>
																<c:when test="${item.bodyKeirikiFlag == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
																	<c:set var="showUchiwake" value="show" />
																</c:when>
																<c:otherwise>
																	<c:set var="showUchiwake" value="none" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
																<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
																<td rowspan="2" class="date">
																	<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
																	<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
																</td>
																<td rowspan="2" class="parts">${item.tankaTani}</td>
																<td rowspan="2" class="number">
																	<fmt:formatNumber type="number" value="${item.tanka}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td rowspan="2">
																	<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
																</td>
															</tr>
															<tr class="${rirekiClass}">
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div id="renban5">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>輸送情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-striped table-hover table-condensed" id="yusoInfo">
													<thead>
														<tr>
															<th colspan="2" style="vertical-align: middle;" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">出荷日</th>
															<th rowspan="2" style="vertical-align: middle;">契約番号</th>
															<th rowspan="2" style="vertical-align: middle;">需要家</th>
															<th rowspan="2" style="vertical-align: middle;">便コード</th>
															<th rowspan="2" style="vertical-align: middle;">出庫場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡場所</th>
															<th rowspan="2" style="vertical-align: middle;">受渡 条件</th>
															<th rowspan="2" style="vertical-align: middle;">物管1-4</th>
															<th rowspan="2" style="vertical-align: middle;">積合コード</th>
															<th rowspan="2" style="vertical-align: middle;">台数</th>
															<th rowspan="2" style="vertical-align: middle;">重量(Kg)</th>
															<th rowspan="2" style="vertical-align: middle;">距離(Km)</th>
															<th rowspan="2" style="vertical-align: middle;">金額</th>
														</tr>
														<tr>
															<th style="vertical-align: middle;" class="teiseiRireki">回数</th>
															<th style="vertical-align: middle;" class="teiseiRireki">区分</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.headInfoList5}" varStatus="headData">
															<c:choose>
																<c:when test="${item.keirikiFlg == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td class="date">
																	<fmt:parseDate value="${item.shukkaDate}" var="parsedshukkaDate" pattern="yyyyMMdd" />
																	<fmt:formatDate pattern="yyyy/MM/dd" value="${parsedshukkaDate}" />
																</td>
																<td>${item.keiyakuNo}</td>
																<td>${item.ichijiJuyoka}<br>${item.ichijiJuyokaName}</td>
																<td>${item.bincd}<br>${item.bincdName}</td>
																<td>${item.shukkoBasho}<br>${item.shukkoBashoName}</td>
																<td>${item.ukewatashiBasho}<br>${item.ukewatashiBashoName}</td>
																<td>${item.ukewatashiJoken}<br>${item.ukewatashiJokenName}</td>
																<td>${item.bukkan14}<br>${item.bukkan14Name}</td>
																<td>${item.tsumiaicd}</td>
																<td>${item.daisu}</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.juryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kyori}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.kingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<h5>費目明細情報</h5>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<div class="panel panel-default">
												<table class="table-list table table-bordered table-condensed">
													<thead>
														<tr>
															<th colspan="2" class="teiseiRireki">訂正</th>
															<th rowspan="2" style="vertical-align: middle;">費目</th>
															<th rowspan="2" style="vertical-align: middle;">業者</th>
															<th rowspan="2" style="vertical-align: middle;">請求年月</th>
															<th rowspan="2" style="vertical-align: middle;">単位単価</th>
															<th rowspan="2" style="vertical-align: middle;">単価</th>
															<th colspan="5">内訳情報</th>
															<th>重量</th>
															<th rowspan="2" style="vertical-align: middle;">内訳</th>
														</tr>
														<tr>
															<th style="" class="teiseiRireki">回数</th>
															<th class="teiseiRireki">区分</th>
															<th>基本</th>
															<th>空トン</th>
															<th>長尺</th>
															<th>休日</th>
															<th>時間外</th>
															<th>金額</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="item" items="${multiBinYusohi.bodyInfoList5}" varStatus="bodyData">
															<c:choose>
																<c:when test="${item.bodyKeirikiFlag == '1'}">
																	<c:set var="rirekiClass" value="teiseiRireki" />
																</c:when>
																<c:otherwise>
																	<c:set var="rirekiClass" value="" />
																</c:otherwise>
															</c:choose>
															<c:choose>
																<c:when test="${fn:substring(item.himokucd, 0, 1)  == 'Z'}">
																	<c:set var="showUchiwake" value="show" />
																</c:when>
																<c:otherwise>
																	<c:set var="showUchiwake" value="none" />
																</c:otherwise>
															</c:choose>
															<tr class="${rirekiClass}">
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKaisu}</td>
																<td rowspan="2" class="parts teiseiRireki">${item.headTeiseiKbn}</td>
																<td rowspan="2">${item.himokucd}<br>${item.himokuName}</td>
																<td rowspan="2">${item.gyoshaCd}<br>${item.gyoshaName}</td>
																<td rowspan="2" class="date">
																	<fmt:parseDate value="${item.seikyuNengetsu}" var="parsedSeikyuNengetsu" pattern="yyyyMM" />
																	<fmt:formatDate pattern="yyyy/MM" value="${parsedSeikyuNengetsu}" />
																</td>
																<td rowspan="2" class="parts">${item.tankaTani}</td>
																<td rowspan="2" class="number">
																	<fmt:formatNumber type="number" value="${item.tanka}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseJuryo+item.uchiwakeKutonJuryo+item.uchiwakeChojakuJuryo+item.uchiwakeJikangaiJuryo+item.uchiwakeKyujitsuJuryo}" />
																</td>
																<td rowspan="2">
																	<button class="btn btn-default" id="detailButton" style="display: ${showUchiwake};">内訳</button>
																</td>
															</tr>
															<tr class="${rirekiClass}">
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeBaseKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKutonKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeChojakuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeJikangaiKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number" value="${item.uchiwakeKyujitsuKingaku}" />
																</td>
																<td class="number">
																	<fmt:formatNumber type="number"
																		value="${item.uchiwakeBaseKingaku+item.uchiwakeKutonKingaku+item.uchiwakeChojakuKingaku+item.uchiwakeJikangaiKingaku+item.uchiwakeKyujitsuKingaku}" />
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="gokei">
									<div class="row">
										<table class="col-md-12 col-sm-12 col-xs-12">
											<tr>
												<td class="col-md-6">
													<h5>合計情報</h5>
												</td>
												<td class="col-md-6" align="right"></td>
											</tr>
										</table>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12 col-xs-12">
											<table class="table-list table-bordered table-striped table-hover table-condensed col-md-12" style="width: 800px;">
												<thead>
													<tr>
														<th style="width: 10px;">#</th>
														<th style="width: 100px;">便コード</th>
														<th style="width: 150px;">重量</th>
														<th style="width: 150px;">金額</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td class="parts">1</td>
														<td class="parts">
															<c:choose>
																<c:when test="${multiBinYusohi.headInfoSum.binCd1 == ''}">
																	<c:out value="-" />
																</c:when>
																<c:otherwise>
																	<c:out value="${multiBinYusohi.headInfoSum.binCd1}" />
																</c:otherwise>
															</c:choose>
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.juryo1}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.kingaku1}" />
														</td>
													</tr>
													<tr>
														<td class="parts">2</td>
														<td class="parts">
															<c:choose>
																<c:when test="${multiBinYusohi.headInfoSum.binCd2 == ''}">
																	<c:out value="-" />
																</c:when>
																<c:otherwise>
																	<c:out value="${multiBinYusohi.headInfoSum.binCd2}" />
																</c:otherwise>
															</c:choose>
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.juryo2}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.kingaku2}" />
														</td>
													</tr>
													<tr>
														<td class="parts">3</td>
														<td class="parts">
															<c:choose>
																<c:when test="${multiBinYusohi.headInfoSum.binCd3 == ''}">
																	<c:out value="-" />
																</c:when>
																<c:otherwise>
																	<c:out value="${multiBinYusohi.headInfoSum.binCd3}" />
																</c:otherwise>
															</c:choose>
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.juryo3}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.kingaku3}" />
														</td>
													</tr>
													<tr>
														<td class="parts">4</td>
														<td class="parts">
															<c:choose>
																<c:when test="${multiBinYusohi.headInfoSum.binCd4 == ''}">
																	<c:out value="-" />
																</c:when>
																<c:otherwise>
																	<c:out value="${multiBinYusohi.headInfoSum.binCd4}" />
																</c:otherwise>
															</c:choose>
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.juryo4}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.kingaku4}" />
														</td>
													</tr>
													<tr>
														<td class="parts">5</td>
														<td class="parts">
															<c:choose>
																<c:when test="${multiBinYusohi.headInfoSum.binCd5 == ''}">
																	<c:out value="-" />
																</c:when>
																<c:otherwise>
																	<c:out value="${multiBinYusohi.headInfoSum.binCd5}" />
																</c:otherwise>
															</c:choose>
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.juryo5}" />
														</td>
														<td class="number">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.kingaku5}" />
														</td>
													</tr>
													<tr>
														<td class="parts" colspan="2" style="font-weight: bold;">合計</td>
														<td class="number" style="font-weight: bold;">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.gokeiJuryo}" />
														</td>
														<td class="number" style="font-weight: bold;">
															<fmt:formatNumber type="number" value="${multiBinYusohi.headInfoSum.gokeiKingaku}" />
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<br>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-xs-12">
							<button class="btn btn-primary" id="updateButton">
								<i class="ic-commit"></i>修正
							</button>
							<button type="button" class="btn btn-default" id="displayHistory">
								<i class="fa fa-eye"></i>&nbsp;&nbsp;表示切替
							</button>
							<button class="btn btn-default" id="backButton">戻る</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<c:url var="home" value="/" scope="request" />
	<script>
		$(document).ready(function() {
			initScreen();
		});

		$("#displayHistory").unbind("click");
		$("#displayHistory").click(function() {
			if ($("#historyShowMode").val() == "hide") {
				$(".teiseiRireki").removeClass("hide");
				$("#historyShowMode").val("show");
				$(".gokeiTab").hide();
			} else if ($("#historyShowMode").val() == "show") {
				$(".teiseiRireki").addClass("hide");
				$("#historyShowMode").val("hide");
				$(".gokeiTab").show();
			}
		});

		$("#backButton").unbind("click");
		$("#backButton").click(function(e) {
			e.preventDefault();
			$('#NFMYGX0150').attr('action', "${home}NFMYGX0150/back");
			$('#NFMYGX0150').submit();
		});

		$('a[data-toggle="tab"]').on('shown.bs.tab', function(e) {
			var target = $(e.target).attr("href") // activated tab
			if (target == '#gokei') {
				$("#displayHistory").hide();
			} else {
				$("#displayHistory").show();
			}
		});

		function initScreen() {
			if ($("#viewMode").val() == '0') {
				$("#multiBinMode").empty();
			} else if ($("#viewMode").val() == '1') {
				$("#singleBinMode").empty();

				switch ($("#activeTab").val()) {
				case '0':
					$("#renban1").addClass('tab-pane fade active in');
					$("#renban2").addClass('tab-pane fade');
					$("#renban3").addClass('tab-pane fade');
					$("#renban4").addClass('tab-pane fade');
					$("#renban5").addClass('tab-pane fade');
					break;
				case '1':
					$("#renban2").addClass('tab-pane fade active in');
					$("#renban1").addClass('tab-pane fade');
					$("#renban3").addClass('tab-pane fade');
					$("#renban4").addClass('tab-pane fade');
					$("#renban5").addClass('tab-pane fade');
					break;
				case '2':
					$("#renban3").addClass('tab-pane fade active in');
					$("#renban1").addClass('tab-pane fade');
					$("#renban2").addClass('tab-pane fade');
					$("#renban4").addClass('tab-pane fade');
					$("#renban5").addClass('tab-pane fade');
					break;
				case '3':
					$("#renban4").addClass('tab-pane fade active in');
					$("#renban1").addClass('tab-pane fade');
					$("#renban2").addClass('tab-pane fade');
					$("#renban3").addClass('tab-pane fade');
					$("#renban5").addClass('tab-pane fade');
					break;
				case '4':
					$("#renban5").addClass('tab-pane fade active in');
					$("#renban1").addClass('tab-pane fade');
					$("#renban2").addClass('tab-pane fade');
					$("#renban3").addClass('tab-pane fade');
					$("#renban4").addClass('tab-pane fade');
					break;
				default:
					$("#renban1").addClass('tab-pane fade active in');
					$("#renban2").addClass('tab-pane fade');
					$("#renban3").addClass('tab-pane fade');
					$("#renban4").addClass('tab-pane fade');
					$("#renban5").addClass('tab-pane fade');
				}

			}
			$(".teiseiRireki").addClass("hide");
			$("#historyShowMode").val("hide");
		}
	</script>
</body>
</html>