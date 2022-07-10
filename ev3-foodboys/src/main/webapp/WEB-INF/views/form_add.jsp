<!-- authot: Kiet -->
<div class="text-center text-2xl opacity-60">Add New {{ var }}</div>
<div class="w-full flex justify-center my-4">
	<form action="/{{ var }}" method="post"
		class="bg-blue-100 px-16 py-8 rounded-lg shadow-md">
		<div>
			First Name <br> <input type="text" name="fname" id="fname"
				placeholder="First Name"
				class="rounded-md border-[1px] border-gray-500 px-2 py-1 focus:border-blue-500 mb-4 mt-1 -ml-1">
		</div>
		<div>
			Last Name <br> <input type="text" name="lname" id="lname"
				placeholder="Last Name"
				class="rounded-md border-[1px] border-gray-500 px-2 py-1 focus:border-blue-500 mb-4 mt-1 -ml-1">
		</div>
		<div>
			Address <br>
			<textarea name="address" rows="3" id="address" placeholder="Address"
				class="rounded-md border-[1px] border-gray-500 px-2 py-1 focus:border-blue-500 mb-4 mt-1 -ml-1"> </textarea>
		</div>
		<div>
			Phone Number <br> <input type="text" name="ph_no" id="ph_no"
				placeholder="Ph No."
				class="rounded-md border-[1px] border-gray-500 px-2 py-1 focus:border-blue-500 mb-4 mt-1 -ml-1">
		</div>
		{% if var == "Employee" %}
		<div class="flex justify-between">
			Position <br> <select name="job" id="job"
				class="bg-white px-2 py-1 rounded-md mx-4">
				<option value="" selected disabled hidden>Select A job</option> {%
				for job in jobs %}
				<option value="{{ job[0] }}">{{ job[1] }}</option> {% endfor %}
			</select>
		</div>
		{% endif %}
		<div class="flex justify-center">
			<button
				class="rounded-lg shadow-md px-3 py-1 bg-blue-500 hover:bg-blue-600 text-white transition-all duration-300 mt-4"
				type="submit">Submit</button>
		</div>
	</form>
</div>