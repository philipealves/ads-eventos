app.controller('ParticipantController', function(EventService) {

	var controller = this;

	controller.init = function() {
		findEvents();
	}

	controller.signIn = function(eventId) {
		signIn(eventId);
	}
	
	controller.findEventById = function(eventId) {
		findEventById(eventId);
	}

	controller.clear = function(id) {
		clear();
	}
	
	function findAll() {
		ParticipantService.findAll().success(function(data) {
			controller.participants = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function signIn(eventId) {
		EventService.signIn(eventId, controller.participant).success(function(data) {
			clear();
			findEvent(eventId)
		}).error(function(err) {
			console.log(err);
		});
	}
	
	function findEventById(eventId) {
		EventService.findById(eventId).success(function(data) {
			controller.event = data;
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