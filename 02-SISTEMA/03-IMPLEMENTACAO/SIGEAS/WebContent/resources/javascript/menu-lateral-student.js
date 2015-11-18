(function($) {
	$(document).ready(function() {

		$('#cssmenu li.active').addClass('open').children('ul').show();

		$('#cssmenu li.activities>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});
		
		$('#cssmenu li.programs>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});
		
		$('#cssmenu li.concessions>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});

		$('#cssmenu li.users>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});
		
		$('#cssmenu li.reports>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});

		$('#cssmenu li.about>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});

		$('#cssmenu li.help>a').on('click', function() {
			$(this).removeAttr('href');
			var element = $(this).parent('li');

			if (element.hasClass('open')) {
				element.removeClass('open');
				element.find('li').removeClass('open');
				element.find('ul').slideUp(200);
			} else {
				element.addClass('open');
				element.children('ul').slideDown(200);
				element.siblings('li').children('ul').slideUp(200);
				element.siblings('li').removeClass('open');
				element.siblings('li').find('li').removeClass('open');
				element.siblings('li').find('ul').slideUp(200);
			}
		});

		

	});
})

(jQuery);
