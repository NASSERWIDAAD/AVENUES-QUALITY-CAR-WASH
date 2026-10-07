package com.avenuesqualitycarwash.app;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView webView = new WebView(this);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.loadDataWithBaseURL(
                null,
                getAppHtml(),
                "text/html",
                "UTF-8",
                null
        );

        setContentView(webView);
    }

    private String getAppHtml() {

        return "<!DOCTYPE html>" +
        "<html>" +
        "<head>" +
        "<meta name='viewport' content='width=device-width, initial-scale=1'>" +

        "<style>" +
        "body{margin:0;background:#09050d;color:white;font-family:Arial,sans-serif;padding:20px;}" +
        ".hero{background:linear-gradient(135deg,#171021,#32134b);padding:22px;border-radius:22px;border:1px solid #6d35a5;}" +
        "h1{margin:0 0 8px;font-size:27px;}" +
        ".sub{color:#d7c9df;line-height:1.5;}" +
        ".card{background:#151019;margin-top:14px;padding:18px;border-radius:18px;}" +
        "label{display:block;margin:12px 0 6px;color:#d9cce1;}" +
        "select,input{width:100%;box-sizing:border-box;padding:13px;border-radius:12px;border:1px solid #594466;background:#0e0a12;color:white;font-size:16px;}" +
        "button{width:100%;padding:15px;margin-top:18px;border:0;border-radius:14px;background:linear-gradient(90deg,#8d3dff,#ff4fba);color:white;font-size:17px;font-weight:bold;}" +
        "</style>" +

        "</head>" +

        "<body>" +

        "<div class='hero'>" +
        "<h1>🚗 AVENUES QUALITY CAR WASH</h1>" +
        "<div class='sub'>3rd Avenue, Ravensmead<br>Strictly hand wash — no fancy machines.</div>" +
        "</div>" +

        "<div class='card'>" +
        "<h2>Book Your Wash</h2>" +

        "<label>Choose Service</label>" +
        "<select id='service'>" +
        "<option>Wash & Go — R50</option>" +
        "<option>Wash & Dry — R70</option>" +
        "<option>Full House Clean — R90</option>" +
        "<option>Bakkies & Taxis — R120</option>" +
        "</select>" +

        "<label>Your Name</label>" +
        "<input id='name' placeholder='Name'>" +

        "<label>WhatsApp Number</label>" +
        "<input id='phone' placeholder='061 955 7387' inputmode='tel'>" +

        "<label>Preferred Date</label>" +
        "<input id='date' type='date'>" +

        "<label>Preferred Time</label>" +
        "<input id='time' type='time'>" +

        "<label>Vehicle</label>" +
        "<input id='vehicle' placeholder='e.g. Mercedes C180'>" +

        "<button onclick='book()'>BOOK VIA WHATSAPP 📲</button>" +

        "</div>" +

        "<script>" +

        "function book() {" +

        "let s=document.getElementById('service').value;" +
        "let n=document.getElementById('name').value;" +
        "let p=document.getElementById('phone').value;" +
        "let d=document.getElementById('date').value;" +
        "let t=document.getElementById('time').value;" +
        "let v=document.getElementById('vehicle').value;" +

        "if(!n||!p||!d||!t||!v){" +
        "alert('Please complete all booking details.');" +
        "return;" +
        "}" +

        "let msg='Hello Avenues Quality Car Wash!%0A%0A' +" +
        "'I would like to book:%0A' +" +
        "'Service: '+encodeURIComponent(s)+'%0A' +" +
        "'Name: '+encodeURIComponent(n)+'%0A' +" +
        "'WhatsApp: '+encodeURIComponent(p)+'%0A' +" +
        "'Date: '+encodeURIComponent(d)+'%0A' +" +
        "'Time: '+encodeURIComponent(t)+'%0A' +" +
        "'Vehicle: '+encodeURIComponent(v);" +

        "location.href='https://wa.me/27619557387?text='+msg;" +

        "}" +

        "</script>" +

        "</body>" +
        "</html>";
    }
}