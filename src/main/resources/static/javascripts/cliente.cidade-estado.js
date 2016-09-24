var Brewer = Brewer || {}

Brewer.Estados = (function() {

	function Estados() {
		this.combo = $('#estado');
		this.emitter = $({});
		this.on = this.emitter.on.bind(this.emitter);
	};

	Estados.prototype.enable = function() {
		this.combo.on('change', onEstadoAlterado.bind(this));
	};

	function onEstadoAlterado() {
		this.emitter.trigger('alterado', this.combo.val());
	}

	return Estados;

}());


Brewer.Cidades = (function() {

	function Cidades(comboEstado) {
		this.comboEstado = comboEstado;
	};

	Cidades.prototype.enable = function() {
		this.comboEstado.on('alterado', onEstadoAlterado.bind(this));
	};

	function onEstadoAlterado(evento, codigoEstado) {
		console.log('codigo estado do combo cidade' , codigoEstado);
	}


	return Cidades;

}());


$(function() {

	var comboEstado = new Brewer.Estados();
	comboEstado.enable();

	var comboCidade = new Brewer.Cidades(comboEstado);
	comboCidade.enable();

});