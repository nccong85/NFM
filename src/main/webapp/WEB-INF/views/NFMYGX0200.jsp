<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>NF&amp;M輸送費計算システム</title>
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>随時処理</h2>
					</div>
				</div>
				<div
					class="alert alert-danger error-area col-md-9 col-sm-12 col-xs-12">
					${message}</div>
				<div class="row">
					<div class="col-md-9 col-sm-12 col-xs-12">
						<table
							class="table-single table-bordered table-condensed col-md-12">
							<tr>
								<td class="caption col-md-2">対象年月</td>
								<td class="col-md-10">2016/07</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="row">
					<form:form action="executeCaculate" method="post"
						id="executeCaculateForm">
						<div class="col-md-9 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>輸送費再計算処理</strong>
								</div>
								<div class="panel-body">
									<span>輸送費再計算処理を実行します。</span>
									<button class="btn btn-primary caculateButton" type="submit">
										<i class="ic-calculator"></i>実行
									</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
				<div class="row">
					<form:form action="deleteYusohi" method="post">
						<div class="col-md-9 col-sm-12 col-xs-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<strong>輸送費再計算処理</strong>
								</div>
								<div class="panel-body">
									<span>輸送マスタHEADと輸送マスタBODYのデータを削除します。</span>
									<button class="btn btn-primary caculateButton" type="submit">
										<i class="ic-calculator"></i>削除
									</button>
								</div>
							</div>
						</div>
					</form:form>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<span>Header</span>
						<div class="panel panel-default" id="userList">
							<table id="table"
								class="table-list table table-bordered table-striped table-hover table-condensed">
								<tr>
									<th>seizosho_kbn</th>
									<th>SojoNo</th>
									<th>head_teisei_kbn</th>
									<th>head_teisei_kaisu</th>
									<th>bincd</th>
									<th>shukka_date</th>
									<th>ukewatashi_basho</th>
									<th>kihon_yuso_kyori</th>
									<th>juryo</th>
									<th>tonkiro</th>
									<th>keireki_flg</th>
								</tr>
								<tbody>
									<c:forEach items="${caculateResult.yusoMasterHeadList}" var="item" varStatus="itr">
										<tr>
											<td class="string">${item.seizoshoKbn}</td>
											<td class="string">${item.sojonoShukkoBasho}-${item.sojonoTorihikiShubetsu}-${item.sojonoOban}</td>
											<td class="number">${item.headTeiseiKbn}</td>
											<td class="string">${item.headTeiseiKaisu}</td>
											<td class="string">${item.binCd}</td>
											<td class="string">${item.shukkaDate}</td>
											<td class="string">${item.ukewatashiBasho}</td>
											<td class="string">${item.kihonYusoKyori}</td>
											<td class="string">${item.juryo}</td>
											<td class="string">${item.tonkiro}</td>
											<td class="string">${item.keirekiFlg}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<span>Body</span>
						<div class="panel panel-default" id="userList1">
							<table id="table"
								class="table-list table table-bordered table-striped table-hover table-condensed">
								<tr>
									<th>SojoNo</th>
									<th>Head Teisei Kbn</th>
									<th>Head Teisei Kaisu</th>
									<th>Himoki</th>
									<th>Body Teisei Kbn</th>
									<th>Body Teisei Kaisu</th>
									<th>GyoshaCd</th>
									<th>SeikyuNengetsu</th>
									<th>TsumiaiCd</th>
									<th>Tanka</th>
									<th>Tani</th>
									<th>Kingaku</th>
									<th>Base Juryo</th>
									<th>Base Kingaku</th>
									<th>Kuton Juryo</th>
									<th>Kuton Kingaku</th>
									<th>Chojaku Juryo</th>
									<th>Chojaku Kingaku</th>
									<th>Jikangai Juryo</th>
									<th>Jikangai Kingaku</th>
									<th>Kyujitsu Juryo</th>
									<th>Kyujitsu Kingaku</th>
									<th>Keiriki</th>
								</tr>
								<tbody>
									<c:forEach items="${caculateResult.yusoMasterBodyList}" var="item" varStatus="itr">
										<tr>
											<td class="string">${item.sojonoShukkoBasho}-${item.sojonoTorihikiShubetsu}-${item.sojonoOban}</td>
											<td class="number">${item.headTeiseiKbn}</td>
											<td class="string">${item.headTeiseiKaisu}</td>
											<td class="string">${item.himokuCd}</td>
											<td class="string">${item.bodyTeiseiKbn}</td>
											<td class="string">${item.bodyTeiseiKaisu}</td>
											<td class="string">${item.gyoshaCd}</td>
											<td class="string">${item.seikyuNengetsu}</td>
											<td class="string">${item.tsumiaiCd}</td>
											<td class="string">${item.tanka}</td>
											<td class="string">${item.tankaTani}</td>
											<td class="string">${item.kingaku}</td>
											<td class="string">${item.uchiwakeBaseJuryo}</td>
											<td class="string">${item.uchiwakeBaseKingaku}</td>
											<td class="string">${item.uchiwakeKutonJuryo}</td>
											<td class="string">${item.uchiwakeKutonKingaku}</td>
											<td class="string">${item.uchiwakeChojakuJuryo}</td>
											<td class="string">${item.uchiwakeChojakuKingaku}</td>
											<td class="string">${item.uchiwakeJikangaiJuryo}</td>
											<td class="string">${item.uchiwakeJikangaiKingaku}</td>
											<td class="string">${item.uchiwakeSonotaJuryo}</td>
											<td class="string">${item.uchiwakeSonotaKingaku}</td>
											<td class="string">${item.keirekiFlg}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
					<span>Body Anbun</span>
						<div class="panel panel-default" id="userList1">
							<table id="table"
								class="table-list table table-bordered table-striped table-hover table-condensed">
								<tr>
									<th>SojoNo</th>
									<th>Head Teisei Kbn</th>
									<th>Head Teisei Kaisu</th>
									<th>Himoki</th>
									<th>Body Teisei Kbn</th>
									<th>Body Teisei Kaisu</th>
									<th>GyoshaCd</th>
									<th>SeikyuNengetsu</th>
									<th>TsumiaiCd</th>
									<th>Tanka</th>
									<th>Tani</th>
									<th>Kingaku</th>
									<th>Base Juryo</th>
									<th>Base Kingaku</th>
									<th>Kuton Juryo</th>
									<th>Kuton Kingaku</th>
									<th>Chojaku Juryo</th>
									<th>Chojaku Kingaku</th>
									<th>Jikangai Juryo</th>
									<th>Jikangai Kingaku</th>
									<th>Kyujitsu Juryo</th>
									<th>Kyujitsu Kingaku</th>
									<th>Keiriki</th>
								</tr>
								<tbody>
									<c:forEach items="${caculateResult.yusoMasterBodyListAnbun}" var="item" varStatus="itr">
										<tr>
											<td class="string">${item.sojonoShukkoBasho}-${item.sojonoTorihikiShubetsu}-${item.sojonoOban}</td>
											<td class="number">${item.headTeiseiKbn}</td>
											<td class="string">${item.headTeiseiKaisu}</td>
											<td class="string">${item.himokuCd}</td>
											<td class="string">${item.bodyTeiseiKbn}</td>
											<td class="string">${item.bodyTeiseiKaisu}</td>
											<td class="string">${item.gyoshaCd}</td>
											<td class="string">${item.seikyuNengetsu}</td>
											<td class="string">${item.tsumiaiCd}</td>
											<td class="string">${item.tanka}</td>
											<td class="string">${item.tankaTani}</td>
											<td class="string">${item.kingaku}</td>
											<td class="string">${item.uchiwakeBaseJuryo}</td>
											<td class="string">${item.uchiwakeBaseKingaku}</td>
											<td class="string">${item.uchiwakeKutonJuryo}</td>
											<td class="string">${item.uchiwakeKutonKingaku}</td>
											<td class="string">${item.uchiwakeChojakuJuryo}</td>
											<td class="string">${item.uchiwakeChojakuKingaku}</td>
											<td class="string">${item.uchiwakeJikangaiJuryo}</td>
											<td class="string">${item.uchiwakeJikangaiKingaku}</td>
											<td class="string">${item.uchiwakeSonotaJuryo}</td>
											<td class="string">${item.uchiwakeSonotaKingaku}</td>
											<td class="string">${item.keirekiFlg}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
				<!-- <div class="row">
					<div class="col-md-9 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>輸送実績データ作成＆ダウンロード</strong>
							</div>
							<div class="panel-body">
								<span>確認用に帳票を出力します。</span>
								<button class="btn btn-primary downloadButton">
									<i class="ic-download"></i>ダウンロード
								</button>
							</div>
						</div>
					</div>
				</div> -->
				<!-- <div class="row">
					<div class="col-md-9 col-sm-12 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<strong>管理資料作成</strong>
							</div>
							<div class="panel-body">
								<span>確認用に帳票を出力します。</span> <span>出力する帳票にチェックを入れて下さい。</span>
								<div class="form-group">
									<div class="checkbox">
										<label> <input type="checkbox" value="" />輸送計算書
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" value="" />業者別種類別輸送費実績表
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" value="" />支店別種類別輸送費実績表
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" value="" />支店別輸送費実績表
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" value="" />業者別種類別輸送費実績表
										</label>
									</div>
								</div>
								<button class="btn btn-primary exportReportButton">
									<i class="ic-file"></i>帳票出力
								</button>
							</div>
						</div>
					</div>
				</div> -->

			</div>
		</div>
	</div>
</body>
</html>