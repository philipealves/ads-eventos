var app = angular.module('adsEventosApp', [ 'ui.router' ]);

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');

	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'pages/home/partial-home.html'
	})
	.state('event', {
		url : '/event',
		templateUrl : 'pages/event/partial-event.html'
	})
	.state('place', {
		url : '/place',
		templateUrl : 'pages/place/partial-place.html'
	})
	.state('participant', {
		url : '/participant',
		templateUrl : 'pages/participant/partial-participant.html'
	})

});