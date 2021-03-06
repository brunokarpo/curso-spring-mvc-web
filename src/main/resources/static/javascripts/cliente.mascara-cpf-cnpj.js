var Brewer = Brewer || {};

Brewer.MascaraCpfCnpj = (function() {

	function MascaraCpfCnpj() {
		this.radioTipoPessoa = $('.js-radio-tipo-pessoa');
		this.labelCpfCnpj = $('[for=cpfCnpj]');
		this.inputCpfCnpj = $('#cpfCnpj');
	};

	MascaraCpfCnpj.prototype.enable = function() {
		this.radioTipoPessoa.change(onTipoPessoaAlterado.bind(this));
	};

	function onTipoPessoaAlterado(evento) {
		var tipoPessoaSelecionada = $(evento.currentTarget);

		this.labelCpfCnpj.text(tipoPessoaSelecionada.data('documento'));
		this.inputCpfCnpj.mask(tipoPessoaSelecionada.data('mascara'));

		this.inputCpfCnpj.val('');
		this.inputCpfCnpj.removeAttr('disabled');
	}

	return MascaraCpfCnpj;

}());

$(function() {
	var mascaraCpfCnpj = new Brewer.MascaraCpfCnpj();
	mascaraCpfCnpj.enable();
});