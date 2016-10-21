app.controller('LocalController', function(LocalService) {
	var controller = this;
	
	controller.save = function(local) {
		LocalService.save(local);
	}
	
	controller.remove = function() {
		LocalService.remove(null);
	}
	
	controller.findById = function() {
		LocalService.findById(null);
	}
	
	controller.findAll = function() {
		LocalService.findAll(null);
	}
	
});