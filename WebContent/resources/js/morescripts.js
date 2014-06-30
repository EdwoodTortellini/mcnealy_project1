$(document).ready(function() {
	// Get the hidden values
	var hdnView = $('#hdnView')[0].value;
	var hdnAdd = $('#hdnAdd')[0].value;
	// Get the forms
	var viewForm = $('#viewMediaForm');
	var addForm = $('#addMediaForm');
	// Get the buttons
	var viewButton = $('#viewMediaButton');
	var addButton = $('#addMediaButton');
	var returnButton = $('#returnButton');
	
	if (hdnView == 'true') {
		viewForm.show();
		viewButton.hide();
	} else {
		viewForm.hide();
		viewButton.show();
	}
	
	if (hdnAdd == 'true') {
		addForm.show();
		addButton.hide();
	} else {
		addForm.hide();
		addButton.show();
	}
	
	if ((hdnAdd == 'true' && hdnView == 'true') || (hdnAdd == 'false' && hdnView == 'true') || (hdnAdd == 'true' && hdnView == 'false')) {
		returnButton.show();
	} else {
		returnButton.hide();
	}
});

function slideIt(id, direction) {
	// Hide the button that slid the element and show the home button
	$('#' + id).hide();
	$('#returnButton').show();

	// Get the page to slide and determine the direction the slide it!
	var page = id == 'addMediaButton' ? $('#addMediaForm')
			: $('#viewMediaForm');
	var direction = id == 'addMediaButton' ? 'right' : 'left';
	slideElement(page, direction);
}

function slideElement(element, direction) {
	var effect = 'slide';
	var options = {
		direction : direction
	};
	var duration = 700;
	element.toggle(effect, options, duration);
}

$('#returnButton').click(function() {
	$(this).hide();
	var buttons = [ $('#addMediaButton'), $('#viewMediaButton') ];
	var pages = [ $('#addMediaForm'), $('#viewMediaForm') ];

	$.each(buttons, function() {
		if (!this.is(':visible'))
			this.show();
	});

	$.each(pages, function() {
		// Get the direction to slide the page. Should be opposite of the one
		// used to show
		if (this.is(':visible')) {
			var direction = this.attr('id') == 'addMediaForm' ? 'right' : 'left';
			slideElement(this, direction);
		}
	});
	
	// Clear the information headers
	$('#persistResult').text('');
	$('#updateResult').text('');
});

$('#addMediaButton').click(function() {
	slideIt(this.id);
});
$('#viewMediaButton').click(function() {
	slideIt(this.id);
});
