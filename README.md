# Food

**Food** is an app to connect shipper, store and custommer.

Time spent: **X** hours spent in total

## User Stories


* [ ] **Custommer** 
	* [ ] register, phone number is required field.
	* [x] can see the food available in the menu
		* [x] View food in category
 		* [ ] View food in timeLine
 		* [ ] Order food
 		* [ ] Request (or answer) favorite food via post on timeline
* [ ] **Stores** could post the products they're ready with price
 	* [ ] Show on category
 	* [ ] Show on timeline
 	* [ ] CRUD their product
 	* [ ] View request from custommer
 	* [ ] update the status of food product (available or sold out)
* [ ] **Shipper** will be
	* [ ] Toggle between status ready or not for delivery
	* [ ] View request Custommer when they order with delivery option is this shipper
	* [ ] agree or decline request of custommer.
* [ ] Auto calculated shipping fee (base on distance from Shipper to Store and Customer 	  using google map API)
	
The following **additional** features are implemented:
* [ ] private message between user of different groups

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='http://i.imgur.com/msG88qf.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android

## License

    Copyright [yyyy] [name of copyright owner]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
