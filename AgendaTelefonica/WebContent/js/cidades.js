(function($) {

$().ready(function() {
	$.paramsPage = {
		contexto: "/AgendaTelefonica/"
	};
	 $('.close-waning').click(function() {$.hideLtWarning(this);});
	 $("#imprimir").click(function() {window.print();});
	 $("#filtrar-cidades").click(function() {$.buscarCidades();});
	 $("#solicitarPedidoRegistro").click(function() {$.checkSelectAgendamento();});
	 
	$.extend({
		buscarCidades: function(){
			if($("#search").val()!=""){
				alert("OK");
					$("")
			}
			else{
				$.showWarning(true,"Preencha o campo Cidade");
			}
		},
		checkSelectAgendamento: function(){
			var selecionouItem = $('.itemAgendamento:checked').length > 0;
			
			if(!selecionouItem){
				$.showWarning(true,"Selecione pelo menos uma cobertura");
			}
			else{
				$.disableButtons();
				$(".loading-area").fadeIn("slow",function() {
					 $("#form").attr("action", $.paramsPage.contexto+"solicitacao-pedido-registro!solicitarPedidoRegistro.action").submit();					
				});
			}
		},
		disableButtons: function (){
			$(".action-button,.denied-button").attr("disabled", true);
			$(".action-button,.denied-button").removeClass("action-button denied-button");
			$('input[type=button]').addClass("disabled-button");
			$.showWarning(false,"");
		},
		hideLtWarning: function (campo){
			$(campo).parent().fadeOut("slow");
		},
		showWarning: function(mostra,mensagem){
			if(mostra){$(".warning-area").fadeIn("slow");$(".warning-message").html(mensagem);}else{$(".warning-area").fadeOut("slow");}
		}
		});
});

})(jQuery);

