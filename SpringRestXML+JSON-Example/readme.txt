1. Create REST WS both for XML and JSON.
   For XML, need a XML data class(RootElement)
   For JSON, just regular class

2. For XML:
    @RequestMapping(value = "/employees")
    public @ResponseBody EmployeeListVO getAllEmployees() 
    {

3. For JSON:
    @RequestMapping(value = "/json/employees")
    public @ResponseBody List<EmployeeVO> getAllEmployeesJSON() 
    {