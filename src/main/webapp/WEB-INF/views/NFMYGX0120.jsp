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
		<form id="NFMYGX0120" action="add" method="post">
			<input id="sukkaDateH" name="sukkaDate" type="hidden" />
			<input id="keiyakuNoH" name="keiyakuNo" type="hidden" />
			<input id="ichijiJuyokaH" name="ichijiJuyoka" type="hidden" />
			<input id="sukkoBashoH" name="sukkoBasho" type="hidden" />
			<input id="bukkan14H" name="bukkan14" type="hidden" />
			<input id="ukewatashiBashoH" name="ukewatashiBasho" type="hidden" />
			<input id="ukewatashiJokenH" name="ukewatashiJoken" type="hidden" />
			<div id="page-wrapper">
				<div id="page-inner">
					<div class="row">
						<div class="col-md-12">
							<h2>輸送費新規登録</h2>
						</div>
					</div>
					<div id="NFMYGX0120_BusinessMessage" class="businessMessageStyle"></div>
					<div class="row">
						<div class="col-sm-12 col-xs-12">
							<h5>出荷情報</h5>
							<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<th class="caption col-md-2 required">送状番号</th>
									<td class="form-inline col-md-4">
										<input id="sojobangoTextbox" class="form-control input-sm" name="sojoNo" type="text" />
										<button class="btn btn-primary" id="checkButton">チェック</button>
									</td>
									<td class="caption col-md-2">出荷日</td>
									<td class="col-md-4 sukkaDateC"></td>
								</tr>
								<tr>
									<td class="caption col-md-2">注文番号</td>
									<td class="col-md-4 keiyakuNoC"></td>
									<td class="caption col-md-2">需要家</td>
									<td class="col-md-4 ichijiJuyokaC"></td>
								</tr>
								<tr>
									<td class="col-md-2 caption">出庫場所</td>
									<td class="col-md-4 sukkoBashoC"></td>
									<td class="col-md-2 caption">物管1-4</td>
									<td class="col-md-4 bukkan14C"></td>
								</tr>
								<tr>
									<td class="col-md-2 caption">受渡場所</td>
									<td class="col-md-4 ukewatashiBashoC"></td>
									<td class="col-md-2 caption">受渡条件</td>
									<td class="col-md-4 ukewatashiJokenC"></td>
								</tr>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-12 col-xs-12">
							<h5>輸送情報</h5>
							<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<th class="caption col-md-2">積港</th>
									<td class="col-md-4">
										<input id="txtTsumiko" class="form-control input-xsmall" name="tsumikomiMinato" type="text" />
									<th class="caption col-md-2">揚港</th>
									<td class="col-md-4">
										<input id="txtAgeko" class="form-control input-xsmall" name="ageMinato" type="text" />
								</tr>
								<tr>
									<td class="caption col-md-2 required">重量</td>
									<td class="col-md-4 form-inline">
										<input id="txtJuryo" class="form-control input-medium number" name="juryo" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">検量料数</th>
									<td class="col-md-4">
										<input id="txtKenryoRyosu" class="form-control input-small" name="yushutsuKenryoRyosu" type="text" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2 required">便コード</th>
									<td class="col-md-4 form-inline">
										<input id="txtBinCd" class="form-control input-xsmall input-sm" name="binCd" type="text" style="width: 60px;" />
										<label class="checkbox-inline">
											<input type="checkbox" class="fukusuBinCheckbox">
											複数便コード
										</label>
										<br>
										<span class="binName" style="font-size: 12px;"></span>
									</td>
									<th class="caption col-md-2">倉庫保管日数</th>
									<td class="col-md-4">
										<input id="txtSokoHokanNitsu" class="form-control input-small" name="yushutsuSokouhokanNissu" type="text" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2 required">業者コード</th>
									<td class="col-md-4 form-inline">
										<input id="txtGyoshaCd" class="form-control input-xsmall" name="gyoshaCd" type="text" style="width: 60px;" />
										<br>
										<span class="gyoshaName" style="font-size: 12px;"></span>
									<th class="caption col-md-2">艀滞船日数</th>
									<td class="col-md-4">
										<input id="txtHashikeTaisenNitsu" class="form-control input-small" name="yushutsuFutaisenNissu" type="text" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">積合コード</th>
									<td class="col-md-4">
										<input id="txtTsumiawaseCd" class="form-control input-xsmall" name="tsumiaiCd" type="text" />
									<th class="caption col-md-2">時間外割増</th>
									<td class="col-md-4">
										<input id="txtJikangaiWarimashi" class="form-control input-small" name="warimashiJikangai" type="text" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">空トンコード</th>
									<td class="col-md-4">
										<input id="txtKutonCd" class="form-control input-xsmall" name="warimashiKuton" type="text" />
									<th class="caption col-md-2">休日割増</th>
									<td class="col-md-4">
										<input id="txtKyujitsuWarimashi" class="form-control input-small" name="warimashiKyujitsu" type="text" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">長尺</th>
									<td class="col-md-4">
										<input id="txtChojaku" class="form-control input-xsmall" name="warimashiChojaku" type="text" />
									<th class="caption col-md-2">留置割増</th>
									<td class="col-md-4">
										<input id="txtTomeoki" class="form-control input-small" name="tomeoki" type="text" />
								</tr>
								<tr>
									<th class="caption col-md-2">長尺１重量</th>
									<td class="col-md-4 form-inline">
										<input id="txtChojakuJuryo1" class="form-control input-small number" name="cho1ju" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">浜出し区分</th>
									<td class="col-md-4">
										<input id="hamadashiKbnTextBox" class="form-control input-small" name="hamaKbn" type="text" style="width: 120px;" />
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">長尺２重量</th>
									<td class="col-md-4 form-inline">
										<input id="txtChojakuJuryo2" class="form-control input-small number" name="cho2ju" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議</th>
									<td class="col-md-4 form-inline">
										<input id="txtBettoKogyo" class="form-control input-small number" name="betto" type="text" style="width: 120px;" />
										<label>円</label>
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2 required">台数</th>
									<td class="col-md-4" colspan="3">
										<input id="ｔxｔDaisu" class="form-control input-xsmall number" name="daisu" type="text" style="width: 120px;" />
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="hide row" id="fukusuBinRow">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<h5>便コード追加</h5>
							<table class="table-single table-bordered table-condensed col-md-12">
								<tr>
									<th class="caption col-md-2">便コード１</th>
									<td class="col-md-2">
										<input id="txtBinCd1" class="form-control input-xsmall" name="binCd1" type="text" />
									</td>
									<th class="caption col-md-2">重量１</th>
									<td class="col-md-2 form-inline">
										<input id="txtJuryo1" class="form-control input-xsmall number" name="juryo1" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議１</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-xsmall number" name="betto1" style="width: 120px;" />
										<label>円</label>
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">便コード２</th>
									<td class="col-md-2">
										<input id="txtbinCd2" class="form-control input-xsmall" name="binCd2" type="text" />
									</td>
									<th class="caption col-md-2">重量２</th>
									<td class="col-md-2 form-inline">
										<input id="txtJuryo2" class="form-control input-xsmall number" name="juryo2" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議２</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" name="betto2" style="width: 120px;" />
										<label>円</label>
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">便コード３</th>
									<td class="col-md-2">
										<input id="txtbinCd3" class="form-control input-xsmall" name="binCd3" type="text" />
									</td>
									<th class="caption col-md-2">重量３</th>
									<td class="col-md-2 form-inline">
										<input id="txtJuryo3" class="form-control input-xsmall number" name="juryo3" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議３</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" name="betto3" style="width: 120px;" />
										<label>円</label>
									</td>
								</tr>
								<tr>
									<th class="caption col-md-2">便コード４</th>
									<td class="col-md-2">
										<input id="txtbinCd4" class="form-control input-xsmall" name="binCd4" type="text" />
									</td>
									<th class="caption col-md-2">重量４</th>
									<td class="col-md-2 form-inline">
										<input id="txtJuryo4" class="form-control input-xsmall number" name="juryo4" type="text" style="width: 120px;" />
										<label>kg</label>
									</td>
									<th class="caption col-md-2">別途協議４</th>
									<td class="col-md-2 form-inline">
										<input type="text" class="form-control input-medium number" name="betto4" style="width: 120px;" />
										<label>円</label>
									</td>
								</tr>
							</table>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-12 col-xs-12">
							<button class="btn btn-primary" id="insertButton">
								<i class="ic-commit"></i>登録
							</button>
							<button class="btn btn-primary" id="insertContinueButton">
								<i class="ic-commit"></i>続けて登録
							</button>
							<button class="btn btn-default" id="cancelButton">キャンセル</button>
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

		$("#cancelButton").unbind("click");
		$("#cancelButton").click(function(e) {
			e.preventDefault();
			$('#NFMYGX0120').attr('action', "back");
			$("#NFMYGX0120").submit();
		});

		$("#insertButton").unbind("click");
		$("#insertButton").click(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var formObj = $('#NFMYGX0120');
			var formURL = formObj.attr("action");
			$.ajax({
			type : "POST",
			url : formURL,
			data : formObj.serialize(),
			success : function(data) {
				if (data.status == "0") {
					$('#NFMYGX0120_BusinessMessage').html("");
					$.infoMsgBox(data.result, function() {
						$('#NFMYGX0120').attr('action', "back");
						$("#NFMYGX0120").submit();
					});

				} else {
					var errorInfo = "";
					for (i = 0; i < data.result.length; i++) {
						errorInfo += "●" + data.result[i].defaultMessage + "<br/>";
					}
					$('#NFMYGX0120_BusinessMessage').html(errorInfo);
				}
			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		});

		$("#insertContinueButton").unbind("click");
		$("#insertContinueButton").click(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var formObj = $('#NFMYGX0120');
			var formURL = formObj.attr("action");
			$.ajax({
			type : "POST",
			url : formURL,
			data : formObj.serialize(),
			success : function(data) {
				if (data.status == "0") {
					$('#NFMYGX0120_BusinessMessage').html("");
					$.infoMsgBox(data.result, function() {
						initScreen();
					});

				} else {
					var errorInfo = "";
					for (i = 0; i < data.result.length; i++) {
						errorInfo += "●" + data.result[i].defaultMessage + "<br/>";
					}
					$('#NFMYGX0120_BusinessMessage').html(errorInfo);
				}
			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		});

		$("#checkButton").unbind("click");
		$("#checkButton").click(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var sojo_No = $("#sojobangoTextbox").val();
			$.ajax({
			type : "POST",
			url : "${home}NFMYGX0120/checkSojoNo/",
			data : {
				sojoNo : sojo_No
			},
			success : function(data) {
				if (data.status == "0") {
					// Clear old message
					$('#NFMYGX0120_BusinessMessage').text("");

					// Set data
					$(".sukkaDateC").html(data.result.sukkaDate);
					$(".keiyakuNoC").html(data.result.keiyakuNo);
					$(".ichijiJuyokaC").html(data.result.ichijiJuyokaName);
					$(".sukkoBashoC").html(data.result.sukkoBashoName);
					$(".bukkan14C").html(data.result.bukkan14Name);
					$(".ukewatashiBashoC").html(data.result.ukewatashiBashoName);
					$(".ukewatashiJokenC").html(data.result.ukewatashiJokenName);

					$('#sukkaDateH').val(data.result.sukkaDate);
					$("#keiyakuNoH").val(data.result.keiyakuNo);
					$("#ichijiJuyokaH").val(data.result.ichijiJuyoka);
					$("#sukkoBashoH").val(data.result.sukkoBasho);
					$("#bukkan14H").val(data.result.bukkan14);
					$("#ukewatashiBashoH").val(data.result.ukewatashiBasho);
					$("#ukewatashiJokenH").val(data.result.ukewatashiJoken);

					// Enable input
					$('input').prop('disabled', false);
					$('#insertButton').prop('disabled', false);
					$('#insertContinueButton').prop('disabled', false);
				} else {
					$('#NFMYGX0120_BusinessMessage').text(data.result);
					$('input').prop('disabled', true);
					$('#insertButton').prop('disabled', true);
					$('#insertContinueButton').prop('disabled', true);
					$('#sojobangoTextbox').prop('disabled', false);
					$('#sojobangoTextbox').focus();
				}

			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		});

		// Fukusu Bin
		$(".fukusuBinCheckbox").unbind("click");
		$(".fukusuBinCheckbox").click(function() {
			if ($(this).is(':checked')) {
				$("#fukusuBinRow").removeClass("hide");
			} else {
				$("#fukusuBinRow").addClass("hide");
			}
		});

		$("#txtBinCd").blur(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var bin_Cd = $("#txtBinCd").val();
			$.ajax({
			type : "POST",
			url : "${home}NFMYGX0120/getBinName/",
			data : {
				binCd : bin_Cd
			},
			success : function(data) {
				$(".binName").text(data.result);
			},
			error : function(e) {
				alert(e);
			},
			done : function(e) {
				alert(e);
			}
			});
		});

		$("#txtGyoshaCd").blur(function(e) {
			// Stop form from submitting normally
			e.preventDefault();

			var gyosha_Cd = $("#txtGyoshaCd").val();
			$.ajax({
			type : "POST",
			url : "${home}NFMYGX0120/getGyoshaName/",
			data : {
				gyoshaCd : gyosha_Cd
			},
			success : function(data) {
				$(".gyoshaName").text(data.result);
			},
			error : function(e) {
				console.log(e);
			},
			done : function(e) {
				console.log(e);
			}
			});
		});

		function initScreen() {
			$('input').val("");
			$('input').prop('disabled', true);
			$('#insertButton').prop('disabled', true);
			$('#insertContinueButton').prop('disabled', true);

			$('#sojobangoTextbox').focus();
			$('#sojobangoTextbox').prop('disabled', false);

			$('#NFMYGX0120_BusinessMessage').text("");
			$(".sukkaDateC").html("");
			$(".keiyakuNoC").html("");
			$(".ichijiJuyokaC").html("");
			$(".sukkoBashoC").html("");
			$(".bukkan14C").html("");
			$(".ukewatashiBashoC").html("");
			$(".ukewatashiJokenC").html("");
		}
	</script>
</body>
</html>