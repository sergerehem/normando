import util.Clock

def clock = new Clock()

if (params.t == "data")
	println clock.getDate()
else if (params.t == "hora")
	println clock.getTime()
else
	println clock.getDateTime()

