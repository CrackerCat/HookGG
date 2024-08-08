print(string.byte("HdShare", 3, 7))
print(string.char(72, 100, 83, 104, 97, 114, 101))
print(string.dump(function() end))
print(string.find("Hello HdShare", "HdShare", 1))
print(string.format("Author: %s", "HdShare"))
for word in string.gmatch("Hello HdShare", "%a+") do print(word) end
print(string.gsub("Hello HdShare", "Hello", "Hi", 1))
print(string.len("HdShare"))
print(string.lower("HdShare"))
print(string.match("2024 year", "%d+ %a+"))
local p = string.pack("i4", 2024)
print(p)
print(string.packsize("i4"))
print(string.rep("Hd", 3))
print(string.reverse("erahSdH"))
print(string.sub("Hello HdShare", 7, 8))
print(string.unpack("i4", p))
print(string.upper("HdShare"))