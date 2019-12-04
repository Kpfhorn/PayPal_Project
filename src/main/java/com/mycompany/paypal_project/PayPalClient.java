package com.mycompany.paypal_project;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "AeRFYy_Tr4PKELb7yQdyMG3CGoGdfUupP1dhhP2iYTeg5ipf9_5HbIQFe0-Cr0YaTD4Uoe-oCRRh811H",
    "EKHim1Yr82nbkFED3O2kb1T6_Io_ESG-eCejx9NopVJAneXChG6i8u4qzxzZCmJmXg5_kQ6_ybAO8lRZ");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}