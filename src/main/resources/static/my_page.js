window.registerExtension('unibzlab/my_page', function (options) {

  // let's create a flag telling if the page is still displayed
  var isDisplayed = true;

  // then do a Web API call to the /api/issues/search to get the number of issues
  // we pass `resolved: false` to request only unresolved issues
  // and `componentKeys: options.component.key` to request issues of the given project
  /*window.SonarRequest.getJSON('/api/issues/search', {
    resolved: false,
    componentKeys: options.component.key
  }).then(function (response) {

    // once the request is done, and the page is still displayed (not closed already)
    if (isDisplayed) {

      // let's create an `h2` tag and place the text inside
      var header = document.createElement('h2');
      header.textContent = 'The project has ' + response.total + ' issues';

      // append just created element to the container
      options.el.appendChild(header);

    }
  });*/


  // Do more stuff on my own
  /*window.SonarRequest.getJSON('/api/issues/search?tags=antipattern,stupid', {
    resolved: false,
    componentKeys: options.component.key
  }).then(function (response) {

    // once the request is done, and the page is still displayed (not closed already)
    if (isDisplayed) {
        var myHeader = document.createElement('h2');
        myHeader.textContent = 'Stupid stuff';
        options.el.appendChild(myHeader);
        var myContent = document.createElement('p');
        myContent.textContent = response;

    }
  });*/

  // return a function, which is called when the page is being closed
  options.el.textContent = 'Hello World';
  return function () {
    options.el.textContent = '';
    // we unset the `isDisplayed` flag to ignore to Web API calls finished after the page is closed
    isDisplayed = false;
  };
});
