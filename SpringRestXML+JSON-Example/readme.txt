1. Create REST WS both for XML and JSON.
   For XML, need a XML data class(RootElement). Need to create XSD file first, see sample XSD file in XML parser sample
   For JSON, just regular class

2. For XML:
    @RequestMapping(value = "/employees")
    public @ResponseBody EmployeeListVO getAllEmployees() 
    {

3. For JSON:
    @RequestMapping(value = "/json/employees")
    public @ResponseBody List<EmployeeVO> getAllEmployeesJSON() 
    {
