package controllers

/**
  * Created by sam on 20/12/16.
  */
import javax.inject.Inject

//import org.zalando.markscheider.MetricsFilter
import play.api.http.DefaultHttpFilters


class Filters @Inject() (
                          log: LoggingFilter
                         //   metricsFilter: MetricsFilter
                        ) extends DefaultHttpFilters(log)
