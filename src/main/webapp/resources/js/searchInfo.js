// TayLQ designed at 20/09/2016

/**
 * LoadSearchInfo
 */
function loadSearchInfo() {

	// check browser support for sessionStorage and sessionStorage
	if (typeof (Storage) !== "undefined") {

		// get value from local storage
		var shukkobasho = sessionStorage.getItem("sojonoshukkobasho");
		var torihikishubetsu = sessionStorage.getItem("sojonotorihikishubetsu");
		var sojonooban = sessionStorage.getItem("sojonooban");
		var shukkadatefrom = sessionStorage.getItem("shukkadatefrom");
		var shukkadateto = sessionStorage.getItem("shukkadateto");
		var watashibasho = sessionStorage.getItem("watashibasho");
		var gyoushacd = sessionStorage.getItem("gyoushacd");
		var himokucd = sessionStorage.getItem("himokucd");
		var tsumiawasecd = sessionStorage.getItem("tsumiawasecd");
		var seikyunengetsu = sessionStorage.getItem("seikyunengetsu");

		// Set value to elements
		if (shukkobasho != null) {
			$("#sojonoshukkobasho").val(shukkobasho);
		}
		if (torihikishubetsu != null) {
			$("#sojonotorihikishubetsu").val(torihikishubetsu);
		}
		if (sojonooban != null) {
			$("#sojonooban").val(sojonooban);
		}
		if (shukkadatefrom != null) {
			$("#shukkadatefrom").val(shukkadatefrom);
		}
		if (shukkadateto != null) {
			$("#shukkadateto").val(shukkadateto);
		}
		if (watashibasho != null) {
			$("#watashibasho").val(watashibasho);
		}
		if (gyoushacd != null) {
			$("#gyoushacd").val(gyoushacd);
		}
		if (himokucd != null) {
			$("#himokucd").val(himokucd);
		}
		if (tsumiawasecd != null) {
			$("#tsumiawasecd").val(tsumiawasecd);
		}
		if (shukkobasho != null) {
			$("#seikyunengetsu").val(seikyunengetsu);
		}
	}
}

/**
 * SaveSearchInfo
 */
function saveSearchInfo() {

	checkValidate();
	// check browser support for sessionStorage and sessionStorage
	if (typeof (Storage) !== "undefined") {

		// get values from elements
		var shukkobasho = $("#sojonoshukkobasho").val();
		var torihikishubetsu = $("#sojonotorihikishubetsu").val();
		var sojonooban = $("#sojonooban").val();
		var shukkadatefrom = $("#shukkadatefrom").val();
		var shukkadateto = $("#shukkadateto").val();
		var watashibasho = $("#watashibasho").val();
		var gyoushacd = $("#gyoushacd").val();
		var himokucd = $("#himokucd").val();
		var tsumiawasecd = $("#tsumiawasecd").val();
		var seikyunengetsu = $("#seikyunengetsu").val();

		if (shukkobasho != null) {
			sessionStorage.setItem("sojonoshukkobasho", shukkobasho);
		}
		if (torihikishubetsu != null) {
			sessionStorage.setItem("sojonotorihikishubetsu", torihikishubetsu);
		}
		if (sojonooban != null) {
			sessionStorage.setItem("sojonooban", sojonooban);
		}
		if (shukkadatefrom != null) {
			sessionStorage.setItem("shukkadatefrom", shukkadatefrom);
		}
		if (shukkadateto != null) {
			sessionStorage.setItem("shukkadateto", shukkadateto);
		}
		if (watashibasho != null) {
			sessionStorage.setItem("watashibasho", watashibasho);
		}
		if (gyoushacd != null) {
			sessionStorage.setItem("gyoushacd", gyoushacd);
		}
		if (himokucd != null) {
			sessionStorage.setItem("himokucd", himokucd);
		}
		if (tsumiawasecd != null) {
			sessionStorage.setItem("tsumiawasecd", tsumiawasecd);
		}
		if (shukkobasho != null) {
			sessionStorage.setItem("seikyunengetsu", seikyunengetsu);
		}
	}
}

function checkValidate() {
	// get values from elements
	var shukkobasho = $("#sojonoshukkobasho").val();
	var torihikishubetsu = $("#sojonotorihikishubetsu").val();
	var sojonooban = $("#sojonooban").val();
	var shukkadatefrom = $("#shukkadatefrom").val();
	var shukkadateto = $("#shukkadateto").val();
	var watashibasho = $("#watashibasho").val();
	var gyoushacd = $("#gyoushacd").val();
	var himokucd = $("#himokucd").val();
	var tsumiawasecd = $("#tsumiawasecd").val();
	var seikyunengetsu = $("#seikyunengetsu").val();

	if (shukkobasho == "" && torihikishubetsu == "" && sojonooban == ""
			&& shukkadatefrom == "" && shukkadateto == "" && watashibasho == ""
			&& gyoushacd == "" && himokucd == "" && tsumiawasecd == ""
			&& seikyunengetsu == "") {
		$("#message").val("検索条件を入力してください。");
		return false;

	} else {
		if ((from_date == "" && to_date != "")
				|| (from_date != "" && to_date == "")) {
			$("#message").text("Date from ? to ? (^_^)");
			return false;
		}
	}
}
