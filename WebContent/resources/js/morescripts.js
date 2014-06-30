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

	if (hdnView == 'true') {
		viewForm.show();
		viewButton.text('Hide');
	} else {
		viewForm.hide();
		viewButton.text("View Media");
	}

	if (hdnAdd == 'true') {
		addForm.show();
		addButton.text('Hide');
	} else {
		addForm.hide();
		addButton.text('Add Media');
	}
});

/**
 * Used to slide a page element into or out of view. Also sets the text of the
 * button accordingly.
 * 
 * @param id
 *            The id of the button that was clicked.
 * @param direction
 *            The direction to slide the page element.
 */
function slideIt(id, direction) {
	var button = $('#' + id);
	// Text to change the button
	var text = id == 'addMediaButton' ? "Add" : "View";
	// The form to slide
	var page = id == 'addMediaButton' ? $('#addMediaForm')
			: $('#viewMediaForm');

	var direction = id == 'addMediaButton' ? 'left' : 'right';
	slideElement(page, direction);

	if (button.text() == 'Hide') {
		button.text(text + ' Media');
		$('#persistResult').text('');
		$('#updateResult').text('');
	} else {
		button.text('Hide');
	}
}

/**
 * Used to slide a page element.
 * 
 * @param element
 *            The element to slide.
 * @param direction
 *            The direction to slide the element.
 */
function slideElement(element, direction) {
	var effect = 'slide';
	var options = {
		direction : direction
	};
	var duration = 700;
	element.toggle(effect, options, duration);
}

// Set the onclick functions for the buttons
$('#addMediaButton').click(function() {
	slideIt(this.id);
});
$('#viewMediaButton').click(function() {
	slideIt(this.id);
});
