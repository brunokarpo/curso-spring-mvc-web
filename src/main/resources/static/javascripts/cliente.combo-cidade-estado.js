var Brewer = Brewer || {}

Brewer.ComboEstado = (function() {

	function ComboEstado() {
		this.combo = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	};

	ComboEstado.prototype.enable = function() {
		this.combo.change(onEstadoAlterado.bind(this));
	};

	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}

	return ComboEstado;

}());


Brewer.ComboCidade = (function() {

	function ComboCidade(comboEstado) {
		this.comboEstado = comboEstado;
		this.combo = $('#cidade');
	};

	ComboCidade.prototype.enable = function() {
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
	};

	function onEstadoAlterado(evento, codigoEstado) {
		var resposta = $.ajax({
			url: this.combo.data('url'),
			method: 'GET',
			contentType: 'application/json',
			data: { 'estado': codigoEstado }
		});
	}


	return ComboCidade;

}());


$(function() {

	var comboEstado = new Brewer.ComboEstado();
	comboEstado.enable();

	var comboCidade = new Brewer.ComboCidade(comboEstado);
	comboCidade.enable();

});