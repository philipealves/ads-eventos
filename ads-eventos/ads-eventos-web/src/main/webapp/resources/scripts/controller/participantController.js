app.controller('ParticipantController', function(EventService) {

	var controller = this;

	controller.init = function() {
		findEvents();
	}

	controller.signIn = function(eventId) {
		signIn(eventId);
	}

	controller.clear = function(id) {
		clear();
	}

	function signIn(eventId) {
		EventService.signIn(eventId, controller.controller.participant).success(function(data) {
			clear();
		}).error(function(err) {
			console.log(err);
		});
	}
	
	function findEvents() {
		EventService.findAll().success(function(data) {
			controller.events = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function clear() {
		controller.event = {};
	}

});