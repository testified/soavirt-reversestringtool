package com.testified.soavirt.tool;

import com.parasoft.api.tool.*;

public class ReverseStringTool implements ICustomTool {

  public boolean acceptsInput(IToolInput input, ICustomToolConfiguration settings) {
    return true;
  }

  public boolean execute(IToolInput input, IToolContext context) throws CustomToolException, InterruptedException {
    ICustomToolConfiguration config = context.getConfiguration();
    String inputString = config.getString("stringtoreverse");
    String reversedString = new StringBuilder(inputString).reverse().toString();
    com.parasoft.api.Application.showMessage("string = " + reversedString);
    DefaultTextInput output = new DefaultTextInput(reversedString, "UTF-8", "text/plain");
    return context.getOutputManager().runOutput("response", output, context);
  }

  public boolean isValidConfig(ICustomToolConfiguration settings) {
    return !settings.getString("stringtoreverse").isEmpty();
  }

}