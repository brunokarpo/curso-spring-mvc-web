var Brewer = Brewer || {};

Brewer.MaskMoney = (function(){

	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	};

	MaskMoney.prototype.enable = function () {
		this.decimal.maskMoney({ thousands:'.', decimal:',' });
		this.plain.maskMoney({ precision: 0, thousands:'.' });
	}

	return MaskMoney;

})();

Brewer.MaskPhoneNumber = (function() {

	function MaskPhoneNumber() {
		this.phoneNumber = $('.js-phone-number');
	}

	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function (val) {
		  return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000' : '(00) 0000-00009';
		};

		var options = {
		  onKeyPress: function(val, e, field, options) {
		      field.mask(maskBehavior.apply({}, arguments), options);
		    }
		};

		this.phoneNumber.mask(maskBehavior, options);
	}

	return MaskPhoneNumber;

}());

Brewer.MaskCepNumber = (function() {

	function MaskCepNumber() {
		this.inputCep = $('.js-cep-number');
	};

	MaskCepNumber.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}

	return MaskCepNumber;
}());


$(function (){
	var maskMoney = new Brewer.MaskMoney();
	maskMoney.enable();

	var maskPhoneNumber = new Brewer.MaskPhoneNumber();
	maskPhoneNumber.enable();

	var maskCepNumber = new Brewer.MaskCepNumber();
	maskCepNumber.enable();
});